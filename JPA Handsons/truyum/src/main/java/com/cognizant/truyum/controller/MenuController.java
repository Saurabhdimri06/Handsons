package com.cognizant.truyum.controller;


import java.util.List;

import javax.transaction.SystemException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cognizant.truyum.model.Menu;
import com.cognizant.truyum.service.MenuService;

//used to define path and handle the model object, for data passing
@Controller
public class MenuController {

	private static final Logger LOGGER = LoggerFactory.getLogger(MenuController.class);
	
	//mapping service so that we can invoke the business logic
	@Autowired
	private MenuService service;
	
	//adding mapping
	@RequestMapping(value="/show-menu-list", method=RequestMethod.GET)
	public String showMenuItemListAdmin(ModelMap model) throws SystemException{
		
		LOGGER.info("Start");
		List<Menu> menu = service.getMenuItemListAdmin();
		LOGGER.debug("Menu Items : {}", menu);
		model.put("menuItem", menu);
		LOGGER.info("End");
		return "menu-item-list-admin";
		
	}
	
	@GetMapping(value="/show-menu-list-customer")
	public String showMenuItemListCustomer(ModelMap model) throws SystemException{
		
		LOGGER.info("Start");
		List<Menu> menu = service.getMenuItemListCustomer();
		
		LOGGER.debug("Menu Items : {}", menu);
		model.put("menuItem", menu);
		LOGGER.info("End");
		return "menu-item-list-customer";
		
	}
	
	@GetMapping(value="“/show-edit-menu-item”")
	public String showEditMenuItem(ModelMap model, @RequestParam("menuItemId") int id) {
		
		LOGGER.info("Start");
		Menu item = service.getMenuItem(id);
		model.put("Item : {}", item);
		LOGGER.debug("Menu Items : {}", item);
		return "edit-menu-item";
	}
	
	@PostMapping(value="/edit-menu-item")
	public String editMenuItem(@ModelAttribute Menu menuItem, BindingResult bindingResult) {
		
		LOGGER.info("Start");
		if(bindingResult.hasErrors()) {
			LOGGER.debug("Errors Binding {}", bindingResult.getFieldError());
		}
		if(menuItem.isDelivery()==false) {
			service.editMenuItem(menuItem);
		}
		LOGGER.info("End");
		return "edit-menu-item-status";
	}

}
