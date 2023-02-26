package com.cg.onlineplantnursery.util;

import org.springframework.stereotype.Component;


import com.cg.onlineplantnursery.entity.Customer;
import com.cg.onlineplantnursery.dto.CustomerDTO;



@Component

public class CustomerDTOConverter {
	
	public CustomerDTO convertTo(Customer customer) {

		return new CustomerDTO(customer.getCustomerId(), customer.getFirstName(), customer.getLastName(), customer.getPhoneNumber(),customer.getEmailId(),
				customer.getAddress());
	}

}
