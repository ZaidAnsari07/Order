package com.everpeak.orders.exception;

public class ResourceNotFoundException extends RuntimeException {

	public ResourceNotFoundException() {
		super("Resource not found !!");
	}

	public ResourceNotFoundException(String message) {
		super(message);
	}
}
