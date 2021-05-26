package ru.lebedev.servicecars.exception;

public class DeleteCarException extends Exception{

    public DeleteCarException() {
    }

    public DeleteCarException(String message) {
        super(message);
    }

    public DeleteCarException(String message, Throwable cause) {
        super(message, cause);
    }

    public DeleteCarException(Throwable cause) {
        super(cause);
    }

    public DeleteCarException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
