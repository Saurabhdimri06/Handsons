package com.cognizant.rest.truyum.collector;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.rest.truyum.TruyumApplication;
import com.cognizant.rest.truyum.model.MenuItem;
import com.cognizant.rest.truyum.service.CartService;
import com.cognizant.rest.truyum.service.exception.CartEmptyException;

@RestController
@RequestMapping("/cart")
public class CartCollector {

	private static final Logger LOGGER = LoggerFactory.getLogger(TruyumApplication.class);
	
	@Autowired
	private CartService service;
	
	@PostMapping("/add/{userId}/{menuItemId}")
	public void addCartItem(@PathVariable("userId") long userId, @PathVariable("id") long menuItemId){
		
		LOGGER.info("Inside Cart Item Service to add Cart item");
		service.addCartItem(userId, menuItemId);
	}
	
	@GetMapping("/get/{userId}")
	public List<MenuItem> getAllCartItems(long userId) throws CartEmptyException{
		
		LOGGER.info("To get item from user id in cart");
		return service.getAllCartItems(userId);
	}
	
	@DeleteMapping("/item/{userId}/{menuItemId}")
	public void removeCartItem(long userId, long menuItemId) {
		
		LOGGER.info("Remove Cart acceseed from collector");
		service.removeCartItem(userId, menuItemId);
	}
}
