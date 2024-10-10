package com.myproject.beitragsrechner.exception;

public class BeitragRechnerNotFoundException extends RuntimeException {
    public BeitragRechnerNotFoundException(String message) {
        super(message);
    }

    public BeitragRechnerNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
