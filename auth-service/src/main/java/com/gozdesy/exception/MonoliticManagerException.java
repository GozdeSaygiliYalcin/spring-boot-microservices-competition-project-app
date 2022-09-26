package com.gozdesy.exception;

import lombok.Getter;
@Getter
public class MonoliticManagerException extends RuntimeException{

    private final ErrorType errorType;

    public MonoliticManagerException(ErrorType errorType) {
        super(errorType.getMessage());
        this.errorType = errorType;
    }

    public MonoliticManagerException(ErrorType errorType, String customMessage) {
        super(customMessage);
        this.errorType = errorType;
    }
}
