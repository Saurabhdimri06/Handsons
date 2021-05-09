package com.cognizant.truyum.controller;

import java.util.List;

import org.omg.CORBA.SystemException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cognizant.truyum.model.Menu;
import com.cognizant.truyum.service.MenuService;

//basically used to define path and handle the model object, for data passing
public class MenuController {

	private static final Logger LOGGER = LoggerFactory.getLogger(MenuController.class);
	
	//mapping service so that we can invoke the business logic
	@Autowired
	MenuService service;
	
	//adding mapping
	@RequestMapping(value="/show-menu-list", method=RequestMethod.GET)
	public String showMenuItemListAdmin(ModelMap model) throws SystemException{
		
		LOGGER.info("Start");
		
		List<Menu> menu = service.getMenuItemListAdmin();
		for(Menu item: menu) {
			model.put("items", item);
		}
		LOGGER.info("End");
		return "menu-item-list-admin";
		
	}

}
