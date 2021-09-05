package ru.goridko_igor.exception;

public class ExpressionBuilderException extends Exception {
    public ExpressionBuilderException() {
    }

    public ExpressionBuilderException(String message) {
        super(message);
    }

    public ExpressionBuilderException(String message, Throwable cause) {
        super(message, cause);
    }

    public ExpressionBuilderException(Throwable cause) {
        super(cause);
    }

    public ExpressionBuilderException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
