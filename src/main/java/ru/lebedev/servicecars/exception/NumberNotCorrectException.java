package ru.lebedev.servicecars.exception;

public class NumberNotCorrectException extends Exception {

    public NumberNotCorrectException() {
    }

    public NumberNotCorrectException(String message) {
        super(message);
    }

    public NumberNotCorrectException(String message, Throwable cause) {
        super(message, cause);
    }

    public NumberNotCorrectException(Throwable cause) {
        super(cause);
    }

    public NumberNotCorrectException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
