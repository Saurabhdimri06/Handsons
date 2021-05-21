package com.cognizant.rest.truyum.service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Cart is Empty. There is no item in cart")
public class CartEmptyException extends Exception{

	private static final long serialVersionUID = -4082202135031453776L;
}
