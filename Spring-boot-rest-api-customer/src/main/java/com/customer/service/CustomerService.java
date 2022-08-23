package com.customer.service;

import com.customer.model.Customer;

public interface CustomerService {

	
	Customer getCustomer(long id) throws Exception;
	
	String addCustomer(Customer customer);
	
	String updateCustomer(Customer customer);
}
