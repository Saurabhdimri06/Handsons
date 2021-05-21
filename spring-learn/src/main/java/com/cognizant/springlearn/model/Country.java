package com.cognizant.springlearn.model;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cognizant.springlearn.SpringLearnApplication;

public class Country {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);

	@NotNull
	@Size(min=2, max=2, message="Country code should be 2 characters") 
	private String code;
	private String name;

	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Country [code=" + code + ", name=" + name + "]";
	}
	public Country() {
		super();
		// TODO Auto-generated constructor stub
		LOGGER.info("Inside Country Constructor");
		
	}
	
	

}
