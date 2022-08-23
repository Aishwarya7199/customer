package com.customer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.customer.exceptions.CustomerAlreadyExist;
import com.customer.exceptions.ErrorResponse;
import com.customer.exceptions.NoSuchCustomerExistException;
import com.customer.model.Customer;
import com.customer.repository.CustomerRepository;
import com.customer.service.CustomerService;

@RestController
public class CustomerController {

	@Autowired
	private CustomerService service;
	
	/**
	 * @param id
	 * @return
	 * @throws Exception 
	 */
	@GetMapping("/getcustomer/{id}")
	public Customer getCustomer(@PathVariable("id") long id) throws Exception
	{
		return service.getCustomer(id);
	}
	
	
	@PostMapping("/addcustomer")
	public String addCustomer(@RequestBody Customer customer)
	{
		return service.addCustomer(customer);
	}
	
	@PutMapping("/updatecustomer")
	public String updateCustomer(@RequestBody Customer customer)
	{
		return service.updateCustomer(customer);
	}
	
	@ExceptionHandler(value=CustomerAlreadyExist.class)
	@ResponseStatus(code=HttpStatus.CONFLICT)
	public ErrorResponse handleCustomerAlreadyExist(CustomerAlreadyExist ex)
	{
		return new ErrorResponse(HttpStatus.CONFLICT.value(),ex.getMessage());
		
	}
	
	@ExceptionHandler(value=NoSuchCustomerExistException.class)
	@ResponseStatus(code=HttpStatus.NOT_FOUND)
	public ErrorResponse handleNoSuchCustomerExistException(NoSuchCustomerExistException ex)
	{
		return new ErrorResponse(HttpStatus.NOT_FOUND.value(),ex.getMessage());
		
	}
}
