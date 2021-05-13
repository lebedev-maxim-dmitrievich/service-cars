package ru.lebedev.servicecars.exception;

public class InvalidateDataCarException extends Exception {

    public InvalidateDataCarException() {
    }

    public InvalidateDataCarException(String message) {
        super(message);
    }

    public InvalidateDataCarException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidateDataCarException(Throwable cause) {
        super(cause);
    }

    public InvalidateDataCarException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
