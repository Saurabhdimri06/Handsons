package com.example.firstspringproject.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.firstspringproject.demo.service.LoginService;

@Controller
public class LoginController {
	
	@Autowired
	LoginService service;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String showLogin() {
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String showWelcome(ModelMap model, @RequestParam String name, @RequestParam String password) {
		
		boolean valid = service.isValid(name, password);
		
		if(!valid) {
			model.put("errorMessage", "Invalid Userid or Password");
			return "login";
		}
		
		model.put("name", name);
		return "welcome";
	}
}
