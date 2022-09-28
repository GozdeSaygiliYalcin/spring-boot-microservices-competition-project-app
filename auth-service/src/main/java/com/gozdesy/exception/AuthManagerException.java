package com.gozdesy.exception;

import lombok.Getter;
@Getter
public class AuthManagerException extends RuntimeException{

    private final ErrorType errorType;

    public AuthManagerException(ErrorType errorType) {
        super(errorType.getMessage());
        this.errorType = errorType;
    }

    public AuthManagerException(ErrorType errorType, String customMessage) {
        super(customMessage);
        this.errorType = errorType;
    }
}
