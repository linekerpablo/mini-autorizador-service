package card.transactions.domain.usecases.transaction;

import card.transactions.domain.commands.TransactionCommand;
import card.transactions.domain.enums.TransactionTypeEnum;
import card.transactions.domain.gateways.transaction.interfaces.TransactionCreateGateway;
import card.transactions.domain.usecases.card.interfaces.CardFindByNumberUseCase;
import card.transactions.domain.usecases.card.interfaces.CardUpdateBalanceUseCase;
import card.transactions.domain.usecases.card.interfaces.CardUpdateUseCase;
import card.transactions.domain.usecases.transaction.interfaces.TransactionCreateUseCase;
import card.transactions.domain.validators.CardBalanceValidators;
import card.transactions.domain.validators.CardPasswordValidators;
import card.transactions.presentation.exceptions.ErrorClientException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TransactionCreateUseCaseImpl implements TransactionCreateUseCase {

    @Autowired
    private TransactionCreateGateway transactionCreateGateway;

    @Autowired
    private CardUpdateBalanceUseCase cardUpdateBalanceUseCase;

    @Autowired
    private CardFindByNumberUseCase cardFindByNumberUseCase;

    @Transactional
    public TransactionCommand execute(TransactionCommand command) {
        var cardCommand = cardFindByNumberUseCase.execute(command.getNumber())
                .orElseThrow(() -> new ErrorClientException(TransactionTypeEnum.CARTAO_INEXISTENTE, HttpStatus.UNPROCESSABLE_ENTITY, "Cartão não existe"));

        CardBalanceValidators.validate(cardCommand.getBalance(), command.getValue());
        Double balance = cardCommand.getBalance() - command.getValue();
        var updated = cardUpdateBalanceUseCase.execute(balance, cardCommand.getId(), cardCommand.getVersion());
        CardPasswordValidators.validate(cardCommand.getPassword(), command.getPassword());

        if (updated >= 1)
            return transactionCreateGateway.execute(command);
        else
            return null;
    }
}
