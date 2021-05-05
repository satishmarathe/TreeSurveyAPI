package com.surveyservice.common;

public class NotFoundException extends RuntimeException {
	
	public NotFoundException(String errorMessage) {
        super(errorMessage);
    }
	
	public NotFoundException(String errorMessage, Throwable t) {
        super(errorMessage,t);
    }
	
}


