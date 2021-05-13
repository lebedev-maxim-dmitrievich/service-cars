package ru.lebedev.servicecars.exception;

public class ValidateDataCarException extends Exception {

    public ValidateDataCarException() {
    }

    public ValidateDataCarException(String message) {
        super(message);
    }

    public ValidateDataCarException(String message, Throwable cause) {
        super(message, cause);
    }

    public ValidateDataCarException(Throwable cause) {
        super(cause);
    }

    public ValidateDataCarException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
