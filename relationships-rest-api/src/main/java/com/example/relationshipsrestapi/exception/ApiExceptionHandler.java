package com.example.relationshipsrestapi.exception;

import java.time.ZonedDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class ApiExceptionHandler {

	@ExceptionHandler(value = ApiRequestException.class)
	public ResponseEntity<Object> handleApiRequestException(ApiRequestException e) {
		
		ApiException apiException = 
				new ApiException(e.getMessage(), HttpStatus.BAD_REQUEST, ZonedDateTime.now());
		
		return new ResponseEntity<Object>(apiException, HttpStatus.BAD_REQUEST);
	
		
	}
}
