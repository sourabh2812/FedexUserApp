package com.fedex.springboot.exception;

import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class UserExceptionHandler {
	
	@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "User not found in system")
	@ExceptionHandler(NoSuchElementException.class)
	public void userNotFoundException() {

	}

}
