package com.cognizant.truyum.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cognizant.truyum.model.Cart;
import com.cognizant.truyum.model.Menu;
import com.cognizant.truyum.service.CartService;
import com.cognizant.truyum.service.MenuService;


@Controller
public class CartController {

	private static final Logger LOGGER = LoggerFactory.getLogger(MenuController.class);
	
	static int total;
	@Autowired
	private CartService cartService;
	
	@Autowired
	private MenuService menuService;
	
	@GetMapping(value="/add-to-cart")
	public String addToCart(@RequestParam int menuId, ModelMap map) {
		
		LOGGER.info("Start");
		List<Menu> menu = menuService.getMenuItemListCustomer();
		map.put("Menu items : {}", menu);
		LOGGER.debug("List {}", menu);
		cartService.addToCart(menuId);
 		LOGGER.info("End");
		return "menu-item-list-customer-notification";
	}
	
	@GetMapping(value="/cart")
	public String cart(ModelMap model) throws Exception{
		
		LOGGER.info("Start");
		List<Cart> carts = cartService.getCart();
		LOGGER.debug("Cart Data : {}" , carts);
		
		if(carts.size() == 0) {
			total = 0;
			return "cart-empty";
		}
		
		for(Cart cart: carts) {
			total += cart.getMenu().getPrice();
		}
		
		model.put("cart", carts);
		model.put("total", total);
		LOGGER.info("End");
		return "cart";
	}
	
	@GetMapping(value="/delete")
	public String deleteItem(@RequestParam int id, ModelMap model) {
		
		LOGGER.info("Start");
		cartService.deleteItem(id);
		List<Cart> carts = cartService.getCart();
		LOGGER.debug("Cart after deletion : {}", carts);
		int total = 0;
		if(carts.size() == 0) {
			total = 0;
			return "cart-empty";
		}
		
		for(Cart cart : carts) {
			total -= cart.getMenu().getPrice();
		}
		
		model.put("cart", carts);
		model.put("total", total);
		LOGGER.info("End");
		return "cart-notification";
	}
	
	
	
}
