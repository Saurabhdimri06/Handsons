package com.cognizant.rest.truyum.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.cognizant.rest.truyum.TruyumApplication;
import com.cognizant.rest.truyum.dao.CartDao;
import com.cognizant.rest.truyum.dao.CartDaoCollectionImpl;
import com.cognizant.rest.truyum.model.MenuItem;
import com.cognizant.rest.truyum.service.exception.CartEmptyException;

@Service
public class CartService {

	private static final Logger LOGGER = LoggerFactory.getLogger(TruyumApplication.class);
	CartDao dao = new CartDaoCollectionImpl();
	
	public void addCartItem(long userId, long menuItemId) {
		LOGGER.info("Inside Cart Service, Add new item to cart");
		dao.addCartItem(userId, menuItemId);
	}
	
	public List<MenuItem> getAllCartItems(long userId) throws CartEmptyException{

		LOGGER.info("Inside Get all elements by UserId in Cart Service");
		return dao.getAllCartItems(userId);
	}
	
	public void removeCartItem(long userId, long menuItemId) {
		
		LOGGER.info("Isnide remove Cart Item in Cart Service");
		dao.removeCartItem(userId, menuItemId);
	}
}
