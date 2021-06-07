package com.cognizant.truyum.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.truyum.TruyumApplication;
import com.cognizant.truyum.exception.AuthorizationException;
import com.cognizant.truyum.feign.AuthorisingClient;
import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.service.MenuItemService;

@RestController
@RequestMapping("/menu-items")
public class MenuItemController {
	private static final Logger LOGGER = LoggerFactory.getLogger(TruyumApplication.class);

	@Autowired
	MenuItemService menuItemService;

	@Autowired
	private AuthorisingClient authorisingClient;

	@GetMapping()
	public List<MenuItem> getAllMenuItems(
			@RequestHeader(value = "Authorization", required = true) String requestTokenHeader)
			throws AuthorizationException {

		LOGGER.info("Start: Inside getAllMenuItems");
		LOGGER.info("End:  getAllMenuItems");
		if (authorisingClient.authorizeTheRequest(requestTokenHeader)) {
			return menuItemService.getMenuItemListCustomer();
		} else {
			throw new AuthorizationException("Not allowed");
		}
	}

	@GetMapping("/{id}")
	public MenuItem getMenuItem(@RequestHeader(value = "Authorization", required = true) String requestTokenHeader,
			@PathVariable("id") long id) throws AuthorizationException {
		LOGGER.info("Start: Inside getMenuItem");
		LOGGER.info("End:  getMenuItem");
		if (authorisingClient.authorizeTheRequest(requestTokenHeader)) {
			return menuItemService.getMenuItem(id);
		} else {
			throw new AuthorizationException("Not allowed");
		}
	}

	@PutMapping()
	public void modifyMenuItem(@RequestHeader(value = "Authorization", required = true) String requestTokenHeader,
			@RequestBody MenuItem menuItem) throws AuthorizationException {
		LOGGER.info("Start: Inside modifyMenuItem");
		if (authorisingClient.authorizeTheRequest(requestTokenHeader)) {
			menuItemService.modifyMenuItem(menuItem);
		} else {
			throw new AuthorizationException("Not allowed");
		}
		LOGGER.info("End:  modifyMenuItem");
	}
}
