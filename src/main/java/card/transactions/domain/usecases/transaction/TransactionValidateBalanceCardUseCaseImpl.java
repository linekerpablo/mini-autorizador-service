package card.transactions.domain.usecases.transaction;

import card.transactions.domain.commands.CardCommand;
import card.transactions.domain.commands.TransactionCommand;
import card.transactions.domain.enums.TransactionTypeEnum;
import card.transactions.domain.usecases.card.interfaces.CardFindByNumberUseCase;
import card.transactions.domain.usecases.transaction.interfaces.TransactionValidateBalanceCardUseCase;
import card.transactions.presentation.exceptions.ErrorClientException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class TransactionValidateBalanceCardUseCaseImpl implements TransactionValidateBalanceCardUseCase {

    @Autowired
    private CardFindByNumberUseCase cardFindByNumberUseCase;

    @Override
    public CardCommand execute(TransactionCommand command) {
        var card = cardFindByNumberUseCase.execute(command.getNumber())
                .orElseThrow(() -> new ErrorClientException(TransactionTypeEnum.CARD_NOT_FOUND, HttpStatus.NOT_FOUND, "Cartão não existe"));

        if (!Objects.equals(card.getPassword(), command.getPassword()))
          throw new ErrorClientException(TransactionTypeEnum.PASSWORD_INVALID, HttpStatus.NOT_FOUND, "Senha inválida");

        if (card.getBalance() < command.getValue())
            throw new ErrorClientException(TransactionTypeEnum.INSUFFICIENT_BALANCE, HttpStatus.NOT_FOUND, "Saldo insuficiente");

        return card;
    }
}
