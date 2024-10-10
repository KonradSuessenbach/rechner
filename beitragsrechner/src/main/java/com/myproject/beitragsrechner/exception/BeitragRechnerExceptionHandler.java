package com.myproject.beitragsrechner.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class BeitragRechnerExceptionHandler {

    @ExceptionHandler(value = {BeitragRechnerNotFoundException.class})
    public ResponseEntity<Object> handleBeitragsRechnerNotFoundException
            (BeitragRechnerNotFoundException beitragRechnerNotFoundException)
    {

        BeitragRechnerException beitragRechnerException = new BeitragRechnerException(
                beitragRechnerNotFoundException.getMessage(),
                beitragRechnerNotFoundException.getCause(),
                HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(beitragRechnerException, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(value = {BeitragMissingParameterException.class})
    public ResponseEntity<String> handleBeitragMissingParameter
            (BeitragMissingParameterException missingParameterException) {

        BeitragRechnerException beitragRechnerException = new BeitragRechnerException(
                missingParameterException.getMessage(),
                HttpStatus.BAD_REQUEST);
        return new ResponseEntity(beitragRechnerException,HttpStatus.BAD_REQUEST);

    }

}
