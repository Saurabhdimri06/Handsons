package com.cognizant.truyum;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.cognizant.truyum.controller.MenuController;
import com.cognizant.truyum.model.Menu;
import com.cognizant.truyum.service.MenuService;

@SpringBootApplication
@ComponentScan("com.*")
public class TruyumApplication {
	
	private static MenuService menuService;
	private static final Logger LOGGER = LoggerFactory.getLogger(MenuController.class);
	
	public static void testGetMenuItemListAdmin() {
		LOGGER.info("Start");
		List<Menu> menu = menuService.getMenuItemListAdmin();
		LOGGER.debug("Menu: {}", menu);
		LOGGER.info("End");
	}
	
	
	public static void main(String[] args) {
		
		LOGGER.info("Inside main");
		ApplicationContext context = SpringApplication.run(TruyumApplication.class, args);
		
		menuService = context.getBean(MenuService.class);
				
		testGetMenuItemListAdmin();
	}

}
