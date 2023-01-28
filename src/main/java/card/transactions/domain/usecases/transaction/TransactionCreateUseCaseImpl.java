package card.transactions.domain.usecases.transaction;

import card.transactions.domain.commands.TransactionCommand;
import card.transactions.domain.gateways.transaction.interfaces.TransactionCreateGateway;
import card.transactions.domain.usecases.card.interfaces.CardFindByNumberUseCase;
import card.transactions.domain.usecases.card.interfaces.CardUpdateUseCase;
import card.transactions.domain.usecases.transaction.interfaces.TransactionValidateBalanceCardUseCase;
import card.transactions.domain.usecases.transaction.interfaces.TransactionCreateUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionCreateUseCaseImpl implements TransactionCreateUseCase {

    @Autowired
    private TransactionCreateGateway transactionCreateGateway;

    @Autowired
    private TransactionValidateBalanceCardUseCase transactionValidateBalanceCardUseCase;

    @Autowired
    private CardUpdateUseCase cardUpdateUseCase;

    @Autowired
    private CardFindByNumberUseCase cardFindByNumberUseCase;

    @Override
    public TransactionCommand execute(TransactionCommand command) {
        var cardCommand = transactionValidateBalanceCardUseCase.execute(command);

        var transactionCommand = transactionCreateGateway.execute(command);

        cardCommand.setBalance(cardCommand.getBalance() - command.getValue());
        cardUpdateUseCase.execute(cardCommand);

        return transactionCommand;
    }
}
