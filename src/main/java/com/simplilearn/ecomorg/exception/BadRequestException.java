package com.simplilearn.ecomorg.exception;

public class BadRequestException extends RuntimeException{

	private static final long serialVersionUID = 6250524378271226226L;
	
	public BadRequestException(String message) {
		super(message);
	}
}
