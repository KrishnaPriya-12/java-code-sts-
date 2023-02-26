package com.cg.onlineplantnursery.controller;

import java.util.ArrayList;



import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.onlineplantnursery.entity.Customer;
import com.cg.onlineplantnursery.service.ICustomerService;
import com.cg.onlineplantnursery.dto.CustomerDTO;
import com.cg.onlineplantnursery.util.CustomerDTOConverter;



@RestController
@RequestMapping("/customer")
@CrossOrigin(origins= {"http://localhost:4200","http://localhost:6001"},allowedHeaders="*")

public class CustomerController {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	ICustomerService customerService;

	@Autowired
	CustomerDTOConverter customerDTOConverter;

	public CustomerController() {
		logger.info("Customer Controller Called");
		System.err.println("Customer Controller Called");

	}

	@PostMapping("/add")

	public ResponseEntity<CustomerDTO> saveCustomer(@RequestBody Customer customer) throws Exception {

		Customer savedCustomer = customerService.registerUser(customer);
		logger.info("----> Customer Saved <----" + savedCustomer);

		CustomerDTO dto = customerDTOConverter.convertTo(savedCustomer);

		return new ResponseEntity<CustomerDTO>(dto, HttpStatus.OK);

	}

	@GetMapping("/list")
	public ResponseEntity<List<CustomerDTO>> getAllCustomers() {

		List<Customer> allCustomersInDB = customerService.getAllCustomers();

		List<CustomerDTO> dtoList = new ArrayList<>();
		for (Customer customer : allCustomersInDB) {

			CustomerDTO dto = customerDTOConverter.convertTo(customer);
			dtoList.add(dto);
		}

		return new ResponseEntity<List<CustomerDTO>>(dtoList, HttpStatus.OK);
	}

	@GetMapping("/customerbycity/{city}")

	public ResponseEntity<List<CustomerDTO>> getCustomerByCity(@PathVariable String city) {

		List<Customer> allCustomers = customerService.getCustomerByCity(city);
		List<CustomerDTO> dto = new ArrayList<>();
		for(Customer customer: allCustomers) {
			CustomerDTO customerDTO = customerDTOConverter.convertTo(customer);
			dto.add(customerDTO);
		}

		return new ResponseEntity<List<CustomerDTO>>(dto, HttpStatus.OK);

	}

	@GetMapping("/Customerbystate/{state}")

	public ResponseEntity<List<CustomerDTO>> getCustomerByState(@PathVariable String state) {

		List<Customer> allCustomers = customerService.getCustomerByState(state);
		List<CustomerDTO> dtoObj= new ArrayList<>();
		for(Customer customer: allCustomers) {
			CustomerDTO CustomerDTO =customerDTOConverter.convertTo(customer);
			dtoObj.add(CustomerDTO);
		}

		return new ResponseEntity<List<CustomerDTO>>(dtoObj, HttpStatus.OK);
	
		
	}

	@GetMapping("/customerbyid/{customerId}")

	public ResponseEntity<CustomerDTO> getCustomerById(@PathVariable int CustomerId) throws Exception {
		Customer customerFromDB = customerService.getCustomerById(CustomerId);
		if (customerFromDB != null) {
			CustomerDTO dto =customerDTOConverter.convertTo(customerFromDB);
			return new ResponseEntity<CustomerDTO>(dto, HttpStatus.OK);
		} else
			return null;
	}

	@PutMapping("/updatecustomer/{customerId}")

	public String updatedCustomer(@PathVariable int customerId) {

		Customer updatedCustomer = customerService.getCustomerById(customerId);
		return updatedCustomer.toString();
	}
	
	@GetMapping("/login/{firstName}/{password}")

	public Integer doLogin(@PathVariable String firstName,@PathVariable String password) throws Exception {
		Customer customerFromDB = customerService.getCustometByFirstName(firstName);
		if (customerFromDB != null) {
			System.err.println(customerFromDB);
			System.err.println(password);
			System.err.println(customerFromDB.getPassword());
			
			if(customerFromDB.getPassword().equals(password))
			{
				System.err.println("inside if password is same");
				return customerFromDB.getCustomerId();
			}else
				return -1;
			
		} else
			return -1;
	}


}
