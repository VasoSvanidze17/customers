package ge.toyboom.customers.exceptions;

import lombok.Getter;

public class IllegalArgumentException extends java.lang.IllegalArgumentException {
    public IllegalArgumentException(String message) {
        super(message);
    }

    @Getter
    public enum ExceptionList {
        ID_MUST_BE_POSITIVE_INTEGER(0, "id must be positive integer");
        ;

        private final int code;
        private final String message;

        ExceptionList(final int code, final String message) {
            this.code = code;
            this.message = message;
        }
    }
}
