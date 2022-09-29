package com.gozdesy.exception;

import lombok.Getter;
@Getter
public class MainServiceException extends RuntimeException{

    private final ErrorType errorType;

    public MainServiceException(ErrorType errorType) {
        super(errorType.getMessage());
        this.errorType = errorType;
    }

    public MainServiceException(ErrorType errorType, String customMessage) {
        super(customMessage);
        this.errorType = errorType;
    }
}
