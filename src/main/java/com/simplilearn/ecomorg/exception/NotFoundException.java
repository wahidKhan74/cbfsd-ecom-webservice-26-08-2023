package com.simplilearn.ecomorg.exception;

public class NotFoundException extends RuntimeException{

	private static final long serialVersionUID = 6250524378271226226L;
	
	public NotFoundException(String message) {
		super(message);
	}
}
