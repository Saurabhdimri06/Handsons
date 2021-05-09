package com.cognizant.truyum.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.truyum.model.Cart;
import com.cognizant.truyum.model.Menu;
import com.cognizant.truyum.model.User;
import com.cognizant.truyum.repository.CartRepository;

@Service
public class CartService {

	@Autowired
	CartRepository repo;
	
	@Autowired
	UserService userService;
	
	@Autowired
	MenuService menuService;
	
	@Transactional
	public void addToCart(int itemId) {
		User user = userService.getUser(1);
		Menu menu = menuService.getMenuItem(itemId);
		
		Cart cart = new Cart();
		cart.setUser(user);
		cart.setMenu(menu);
		repo.save(cart);
	}
	
	@Transactional
	public void deleteItem(int id){
		repo.delete(repo.getOne(id));
	}

	@Transactional
	public List<Cart> getCart() {
		// TODO Auto-generated method stub
		return repo.findById(1);
	}
}
