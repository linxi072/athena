package com.mezo.athena.admin.common.exception;

public class IllegalDataException extends RuntimeException {

    private String errorCode;

    public IllegalDataException(String errorMessage) {
        super(errorMessage);
    }

    public IllegalDataException(String errorCode, String errorMessage) {
        super(errorMessage);
        this.errorCode = errorCode;
    }
}
