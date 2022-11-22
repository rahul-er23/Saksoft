package com.saksoft.rahul.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException extends Exception{
	
	@ExceptionHandler(value= {Exception.class})
	public ResponseEntity<String> handler(EmptyException e){
		String msg=e.getMessage();
		String code="52099";
		return new ResponseEntity<String> (msg +" "+ code,HttpStatus.NO_CONTENT);
	}

}
