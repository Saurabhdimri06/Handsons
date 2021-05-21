package com.cognizant.rest.truyum.service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "MenuItem not found")
public class MenuItemNotFoundException extends Exception{
	
	private static final long serialVersionUID = -4082202135031453776L;
}
