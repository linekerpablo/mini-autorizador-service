package card.transactions.presentation.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Order(Ordered.HIGHEST_PRECEDENCE)
@RestController
@RestControllerAdvice
public class ExceptionsHandler extends ResponseEntityExceptionHandler {
    public static final Logger logger = LoggerFactory.getLogger(ExceptionsHandler.class);
    @ExceptionHandler(value = ErrorClientException.class)
    public ResponseEntity<Object> exception(ErrorClientException exception) {
        logger.error(exception.getMessage(), exception);

        return ResponseEntity.status(exception.getHttpStatus()).body(exception.getData());
    }
}
