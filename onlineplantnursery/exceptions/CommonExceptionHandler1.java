package com.cg.onlineplantnursery.exceptions;

import java.time.LocalDateTime;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.cg.onlineplantnursery.dto.ExceptionDTOResponse;

@ControllerAdvice
public class CommonExceptionHandler1 {
	
	@ExceptionHandler
	 public ResponseEntity<ExceptionDTOResponse> invalidName(InvalidCustomerException e)
	 {
	  ExceptionDTOResponse dto = new ExceptionDTOResponse();
	  dto.setErrorMsg(e.toString());
	  dto.setDateTime(LocalDateTime.now()+"");
	  return new ResponseEntity<ExceptionDTOResponse>(dto,HttpStatus.BAD_REQUEST);
	 }
	              
	 @ExceptionHandler
	 public ResponseEntity<ExceptionDTOResponse> invalidPassword(NullPointerException e)
	 {
	  ExceptionDTOResponse dto = new ExceptionDTOResponse();
	  dto.setErrorMsg(e.toString());
	  dto.setDateTime(LocalDateTime.now()+"");
	  return new ResponseEntity<ExceptionDTOResponse>(dto,HttpStatus.BAD_REQUEST);
	 }

}
