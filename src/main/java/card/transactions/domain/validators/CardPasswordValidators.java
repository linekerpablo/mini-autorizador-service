package card.transactions.domain.validators;

import card.transactions.domain.enums.TransactionTypeEnum;
import card.transactions.presentation.exceptions.ErrorClientException;
import org.springframework.http.HttpStatus;

import java.util.Objects;

public class CardPasswordValidators {

    public static void validate(String currentPassword, String requestPassword) {
        if (!Objects.equals(currentPassword, requestPassword))
            throw new ErrorClientException(TransactionTypeEnum.SENHA_INVALIDA, HttpStatus.UNPROCESSABLE_ENTITY, "Senha inválida");
    }
}
