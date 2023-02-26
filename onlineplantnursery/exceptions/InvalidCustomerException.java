package com.cg.onlineplantnursery.exceptions;

import lombok.AllArgsConstructor;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor


public class InvalidCustomerException extends Exception{
	
	String fieldName;
	String msg;
	
	
	@Override
	public String toString() {
		return "CustomerException [fieldName=" + fieldName + ", msg=" + msg + "]";
	}	
	
	

}
