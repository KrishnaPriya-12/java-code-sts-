package com.cg.onlineplantnursery.exceptions;

import java.time.LocalDateTime;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.cg.onlineplantnursery.dto.ExceptionDTOResponse;

@ControllerAdvice
	public class CommonExceptionHandler2 {

		@ExceptionHandler
		public ResponseEntity<ExceptionDTOResponse> doSomeThings(EntityNotFoundException e)
		{
			ExceptionDTOResponse dto = new ExceptionDTOResponse();
			dto.setErrorMsg(e.getMessage());
			dto.setDateTime(LocalDateTime.now()+"");
			return new ResponseEntity<ExceptionDTOResponse>(dto,HttpStatus.BAD_REQUEST);
		}
	
}
