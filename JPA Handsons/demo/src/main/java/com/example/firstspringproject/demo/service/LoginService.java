package com.example.firstspringproject.demo.service;

import org.springframework.stereotype.Component;

@Component
public class LoginService {
	
	public boolean isValid(String id, String password) {
		return id.equalsIgnoreCase("Saurabh") && password.equalsIgnoreCase("hello");
	}
}
