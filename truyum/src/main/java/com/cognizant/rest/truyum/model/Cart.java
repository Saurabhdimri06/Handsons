package com.cognizant.rest.truyum.model;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cognizant.rest.truyum.TruyumApplication;

public class Cart {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(TruyumApplication.class);
	
	private List<MenuItem> menuItemList;
	private double total;

	public Cart(List<MenuItem> menuItemList, double total) {
		super();
		this.menuItemList = menuItemList;
		this.total = total;
	}

	public List<MenuItem> getMenuItemList() {
		return menuItemList;
	}

	public void setMenuItemList(List<MenuItem> menuItemList) {
		this.menuItemList = menuItemList;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "Cart [menuItemList=" + menuItemList + ", total=" + total + "]";
	}

	public Cart() {
		super();
		LOGGER.info("Inside Cart Constructor");
		// TODO Auto-generated constructor stub
	}
	
	

}
