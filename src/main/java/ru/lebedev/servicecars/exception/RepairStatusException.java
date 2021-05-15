package ru.lebedev.servicecars.exception;

public class RepairStatusException extends Exception{

    public RepairStatusException() {
    }

    public RepairStatusException(String message) {
        super(message);
    }

    public RepairStatusException(String message, Throwable cause) {
        super(message, cause);
    }

    public RepairStatusException(Throwable cause) {
        super(cause);
    }

    public RepairStatusException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
