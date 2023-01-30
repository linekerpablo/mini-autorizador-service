package card.transactions.domain.validators;

import card.transactions.domain.enums.TransactionTypeEnum;
import card.transactions.presentation.exceptions.ErrorClientException;
import org.springframework.http.HttpStatus;

public class CardBalanceValidators {

    public static void validate(Double balance, Double value) {
        if (balance < value)
            throw new ErrorClientException(TransactionTypeEnum.SALDO_INSUFICIENTE, HttpStatus.UNPROCESSABLE_ENTITY, "Saldo insuficiente");
    }
}
