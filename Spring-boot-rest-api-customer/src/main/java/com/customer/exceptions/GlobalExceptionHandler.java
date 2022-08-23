package com.customer.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(value=CustomerAlreadyExist.class)
	@ResponseStatus(code=HttpStatus.CONFLICT)
	public @ResponseBody ErrorResponse handleCustomerAlreadyExist(CustomerAlreadyExist ex)
	{
		return new ErrorResponse(HttpStatus.CONFLICT.value(),ex.getMessage());
		
	}
	
	@ExceptionHandler(value=NoSuchCustomerExistException.class)
	@ResponseStatus(code=HttpStatus.NOT_FOUND)
	public @ResponseBody ErrorResponse handleNoSuchCustomerExistException(NoSuchCustomerExistException ex)
	{
		return new ErrorResponse(HttpStatus.NOT_FOUND.value(),ex.getMessage());
		
	}
}
