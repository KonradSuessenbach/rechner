package com.myproject.beitragsrechner.exception;

public class BeitragMissingParameterException extends RuntimeException {
    public BeitragMissingParameterException(String missingParamName) {
        super("Der Wert für " + missingParamName + " fehlt!");
    }
}
