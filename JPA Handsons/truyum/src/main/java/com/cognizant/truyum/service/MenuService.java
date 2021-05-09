package com.cognizant.truyum.service;

import java.util.List;

import com.cognizant.truyum.model.Menu;

public interface MenuService {

	public List<Menu> getMenuItemListAdmin();
	public List<Menu> getMenuItemListCustomer();
	public Menu getMenuItem(int id);
	public void editMenuItem(Menu menu);
}
