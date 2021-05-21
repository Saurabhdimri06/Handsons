package com.cognizant.rest.truyum.collector;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.rest.truyum.TruyumApplication;
import com.cognizant.rest.truyum.model.MenuItem;
import com.cognizant.rest.truyum.service.MenuItemService;
import com.cognizant.rest.truyum.service.exception.MenuItemNotFoundException;

@RestController
@RequestMapping("/menuitem")
public class MenuItemCollector {

	private static final Logger LOGGER = LoggerFactory.getLogger(TruyumApplication.class);
	
	@Autowired
	private MenuItemService service;
	
	@GetMapping("/admin")
	public List<MenuItem> getMenuItemListAdmin(){
		
		LOGGER.info("Inside Collector for Get MenuItem Admin");
		return service.getMenuItemListAdmin();
	}
	
	@GetMapping("/customer")
	public List<MenuItem> getMenuItemListCustomer(){
		
		LOGGER.info("Inside Collector for Get MenuItem Customer");
		return service.getMenuItemListCustomer();
	}
	
	@PutMapping("/update")
	public void modifyMenuItem(@RequestBody MenuItem menuItem) throws MenuItemNotFoundException {
		
		LOGGER.info("Inside Collector for update/modify MenuItem Customer");
		service.modifyMenuItem(menuItem);
	}
	
	@GetMapping("/item/{id}")
	public MenuItem getMenuItem(@PathVariable("id") long id) throws MenuItemNotFoundException{
		
		LOGGER.info("Inside Collector for update/modify MenuItem Customer");
		return service.getMenuItem(id);
	}
}
