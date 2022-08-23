package com.customer.exceptions;

public class NoSuchCustomerExistException extends RuntimeException{
private String message;

public NoSuchCustomerExistException() {
	
}

public NoSuchCustomerExistException(String message) {
	super(message);
	this.message = message;
}
}
