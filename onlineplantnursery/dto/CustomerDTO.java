package com.cg.onlineplantnursery.dto;



import com.cg.onlineplantnursery.entity.Address;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor



public class CustomerDTO {
	
	private int customerId;
	private String firstName;
	private String lastName;
	private long phoneNumber;
	private String emailId;
	private Address address;
	
	

}
