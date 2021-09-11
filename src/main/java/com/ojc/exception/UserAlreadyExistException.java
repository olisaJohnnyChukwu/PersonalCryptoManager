package com.ojc.exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;


@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class UserAlreadyExistException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String resourceName;
	
	
	
	public UserAlreadyExistException(String resourceName) {
		super(String.format("the email '%s' alredy exist",resourceName));
		this.resourceName = resourceName;
	
	}
	
	
	
}
