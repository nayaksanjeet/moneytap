package com.moneytap.bitcoinwatcher.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorHandler {

	@ExceptionHandler(MoneyTapError.class)
	public ResponseEntity<MoneyTapError>getError(Exception e){
		MoneyTapError error=new MoneyTapError();
		error.setErrorCode(""+500);
		error.setErrorMessasge(e.getMessage());
		return new ResponseEntity<MoneyTapError>(error,HttpStatus.BAD_REQUEST);
	}
	
}
