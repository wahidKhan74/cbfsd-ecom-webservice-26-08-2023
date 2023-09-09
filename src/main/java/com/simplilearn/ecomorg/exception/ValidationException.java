package com.simplilearn.ecomorg.exception;

public class ValidationException  extends RuntimeException{

	private static final long serialVersionUID = 6250524378271226225L;
	
	public ValidationException(String message) {
		super(message);
	}
}
