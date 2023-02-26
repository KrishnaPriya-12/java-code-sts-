package com.cg.onlineplantnursery.service;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.onlineplantnursery.entity.Customer;
import com.cg.onlineplantnursery.repository.ICustomerRepository;
import com.cg.onlineplantnursery.exceptions.InvalidCustomerException;


@Service

public class CustomerServiceImpl implements ICustomerService{
	
	@Autowired
	ICustomerRepository customerRepository;

	@Override
	public Customer registerUser(Customer customer) throws InvalidCustomerException {

		if(customer.getFirstName().equals("") || customer.getLastName().equals("")) {
			throw new InvalidCustomerException("Customer name","First Name or Last Name is null");
		}
		
		if(customer.getEmailId().equals("")) {
			throw new InvalidCustomerException("Email Id","Email Id cannot be null");
		}
		if(customer.getPassword().equals("")) {
			throw new InvalidCustomerException("Password", "Password cannot be null");
		}
		return customerRepository.save(customer);
	}

	@Override
	public List<Customer> getAllCustomers() {

		return customerRepository.findAll();
	}

		
	

	@Override
	
	public List<Customer> getCustomerByCity(String searchCity) {
		//get all users 
		List<Customer> allCustomers = customerRepository.findAll();
		//Filter user through for loop based on city
		List<Customer> allCustomerByCity = new ArrayList<>();
		for(Customer customer : allCustomers) {
			String customerCity = customer.getAddress().getCity();
		if(customerCity.equals(searchCity)) {
			allCustomerByCity.add(customer);
		}
		}
		
		return allCustomerByCity;
	}
	
	

	@Override
	public List<Customer> getCustomerByState(String searchstate) {
		
		List<Customer> allCustomers = customerRepository.findAll();
		List<Customer> allCustomerByState = new ArrayList<>();
		for (Customer customer: allCustomers) {
			String customerState = customer.getAddress().getState();
			if(customerState.equals(searchstate)) {
				allCustomerByState.add(customer);
			}
		}
		return allCustomerByState;
	}

	@Override
	public Customer getCustomerById(int customerId) {
		
		Customer customerFromDB = customerRepository.getReferenceById(customerId);
		customerRepository.getReferenceById(customerId);
	
		return customerFromDB;
	}

	@Override
	public Customer updateCustomer(int customerId) {
	
		Customer updatedCustomer = customerRepository.getReferenceById(customerId);
		customerRepository.save(updatedCustomer);
		return updatedCustomer;
	}

	@Override
	public Customer getCustometByFirstName(String firstName) {
	
		return customerRepository.getCustometByFirstName(firstName);
	}

	

}
