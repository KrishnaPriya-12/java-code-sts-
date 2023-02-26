package com.cg.onlineplantnursery.exceptions;

import java.time.LocalDateTime;


import javax.persistence.EntityNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.cg.onlineplantnursery.dto.ExceptionDTOResponse;

@ControllerAdvice
public class CommonExceptionHandler {
	@ExceptionHandler
	public ResponseEntity<ExceptionDTOResponse> doSomeThings(OrderIdNotFoundException e)
	{
		ExceptionDTOResponse dto = new ExceptionDTOResponse();
		dto.setErrorMsg(e.getMessage());
		dto.setDateTime(LocalDateTime.now()+"");
		return new ResponseEntity<ExceptionDTOResponse>(dto,HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler
	public ResponseEntity<ExceptionDTOResponse> doSomeThings(CustomerIdNotFoundException e)
	{
		ExceptionDTOResponse dto = new ExceptionDTOResponse();
		dto.setErrorMsg(e.getMessage());
		dto.setDateTime(LocalDateTime.now()+"");
		return new ResponseEntity<ExceptionDTOResponse>(dto,HttpStatus.BAD_REQUEST);
	}
	
	
	
	@ExceptionHandler
	public ResponseEntity<ExceptionDTOResponse> doSomeThingForNullInput(NullPointerException e)
	{
		ExceptionDTOResponse dto = new ExceptionDTOResponse();
		dto.setErrorMsg(e.toString());
		dto.setDateTime(LocalDateTime.now()+"");
		return new ResponseEntity<ExceptionDTOResponse>(dto,HttpStatus.BAD_REQUEST);
	}

}
