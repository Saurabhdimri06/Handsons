package com.cognizant.rest.truyum.dao;

import java.util.List;

import com.cognizant.rest.truyum.model.MenuItem;
import com.cognizant.rest.truyum.service.exception.CartEmptyException;

public interface CartDao {

	public void addCartItem(long userId, long menuItemId);
	public List<MenuItem> getAllCartItems(long userId) throws CartEmptyException;
	public void removeCartItem(long userId, long menuItemId);
}