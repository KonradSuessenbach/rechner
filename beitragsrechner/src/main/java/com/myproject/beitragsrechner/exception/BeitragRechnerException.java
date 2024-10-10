package com.myproject.beitragsrechner.exception;

import org.springframework.http.HttpStatus;

public class BeitragRechnerException {
    private final String message;
    private final Throwable throwable;
    private final HttpStatus httpStatus;

    public BeitragRechnerException(String message, Throwable throwable, HttpStatus httpStatus) {
        this.message = message;
        this.throwable = throwable;
        this.httpStatus = httpStatus;
    }
    public BeitragRechnerException(String message, HttpStatus httpStatus) {
        this.message = message;
        this.httpStatus = httpStatus;
        this.throwable = null;
    }


    public String getMessage() {
        return message;
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}
