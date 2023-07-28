package ge.toyboom.customers.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundException extends RuntimeException{
    public NotFoundException(String message) {
        super(message);
    }

    @Getter
    public enum ExceptionList {
        CUSTOMER_NOT_FOUND(0, "customer not found");
        ;

        private final int code;
        private final String message;

        ExceptionList(final int code, final String message) {
            this.code = code;
            this.message = message;
        }
    }
}
