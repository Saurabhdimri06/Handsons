package com.cognizant.rest.truyum.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.cognizant.rest.truyum.TruyumApplication;
import com.cognizant.rest.truyum.dao.MenuItemDao;
import com.cognizant.rest.truyum.dao.MenuItemDaoCollectionImpl;
import com.cognizant.rest.truyum.model.MenuItem;

@Service
public class MenuItemService {

	private static final Logger LOGGER = LoggerFactory.getLogger(TruyumApplication.class);
	MenuItemDao dao = new MenuItemDaoCollectionImpl();
	
	public List<MenuItem> getMenuItemListAdmin(){
		LOGGER.info("Inside Get MenuItemList Admin Wise Service");
		return dao.getMenuItemListAdmin();
	}
	
	public List<MenuItem> getMenuItemListCustomer(){
		LOGGER.info("Inside Get MenuItemList Customer Wise Service");
		return dao.getMenuItemListCustomer();
	}
	
	public void modifyMenuItem(MenuItem menuItem) {
		LOGGER.info("Inside Editing MenuItem Service");
		dao.modifyMenuItem(menuItem);
	}
	
	public MenuItem getMenuItem(long menuItemId) {
		LOGGER.info("Inside get MenuItem Service, Get MenuItem ID wise");
		return dao.getMenuItem(menuItemId);
	}
}
