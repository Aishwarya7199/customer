package com.customer.exceptions;

public class CustomerAlreadyExist extends RuntimeException {
	
	
 private String message;

public CustomerAlreadyExist() {
}

public CustomerAlreadyExist(String message) {
	super(message);
	this.message = message;
}
 
 
}
