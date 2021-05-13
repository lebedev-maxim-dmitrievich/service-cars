package ru.lebedev.servicecars.exception;

public class OldCarException extends Exception {

    public OldCarException() {
    }

    public OldCarException(String message) {
        super(message);
    }

    public OldCarException(String message, Throwable cause) {
        super(message, cause);
    }

    public OldCarException(Throwable cause) {
        super(cause);
    }

    public OldCarException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
