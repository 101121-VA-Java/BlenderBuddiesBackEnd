package com.revature.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="No user of that id")
	@ExceptionHandler(UserNotFoundException.class)
	public void handleUserNotFoundException() {
		// do something, ie: log
	}
	
	@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="The smoothie was not found")
	@ExceptionHandler(SmoothieNotFoundException.class)
	public void handleIngredientNotFoundException() {
		// do something, ie: log
	}

	@ResponseStatus(value=HttpStatus.UNAUTHORIZED, reason="Invalid user information")
	@ExceptionHandler(LoginException.class)
	public void handleLoginException() {
		
	}
	
	@ResponseStatus(value=HttpStatus.BAD_REQUEST, reason="Bad Request")
	@ExceptionHandler(Exception.class)
	public void handleException() {
		// do something else
	}
	
}
