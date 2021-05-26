package ru.lebedev.servicecars.exception;

public class UpdateCarException extends Exception {

    public UpdateCarException() {
    }

    public UpdateCarException(String message) {
        super(message);
    }

    public UpdateCarException(String message, Throwable cause) {
        super(message, cause);
    }

    public UpdateCarException(Throwable cause) {
        super(cause);
    }

    public UpdateCarException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
