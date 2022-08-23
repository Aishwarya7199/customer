package com.customer.service;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customer.exceptions.CustomerAlreadyExist;
import com.customer.exceptions.NoSuchCustomerExistException;
import com.customer.model.Customer;
import com.customer.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

	
	@Autowired
	private CustomerRepository repository;
	
	
	@Override
	public Customer getCustomer(long id) throws Exception {
		
		return repository.findById(id).orElseThrow(
		() -> new NoSuchElementException("No customer present with id "+id));
	}

	
	
	
	@Override
	public String addCustomer(Customer customer) {
		
		Customer existCustomer=repository.findById(customer.getId()).orElse(null);
		
		if(existCustomer == null)
		{
			repository.save(customer);
			return "Customer added successfully!!";
		}
		else
		{
			throw new CustomerAlreadyExist("Customer already exist");
		}
		
		
	}

	@Override
	public String updateCustomer(Customer customer) {
     Customer existingCustomer=repository.findById(customer.getId()).orElse(null);
		 
		 if(existingCustomer == null)
		 {
			throw new  NoSuchCustomerExistException("No such customer exist!!");
		 }
		 else
		 {
			existingCustomer.setName(customer.getName());
			existingCustomer.setAddress(customer.getAddress());
			repository.save(existingCustomer);
			return "Record updated successfully!!";
		 }
	}

}
