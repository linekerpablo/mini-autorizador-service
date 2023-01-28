package card.transactions.presentation.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ErrorClientException extends RuntimeException {
    protected Object data;

    protected HttpStatus httpStatus;

    public ErrorClientException(Object data, HttpStatus httpStatus, String message)
    {
        super(message);
        this.data = data;
        this.httpStatus = httpStatus;
    }
}
