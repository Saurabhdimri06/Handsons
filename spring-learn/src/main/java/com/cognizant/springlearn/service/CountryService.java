package com.cognizant.springlearn.service;

import java.util.List;
import java.io.Closeable;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.cognizant.springlearn.SpringLearnApplication;
import com.cognizant.springlearn.model.Country;
import com.cognizant.springlearn.service.exception.CountryNotFoundException;

@Service
public class CountryService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);

	public Country getCountry(String code) throws IOException, CountryNotFoundException {
		// TODO Auto-generated method stub
		LOGGER.info("Inside get country by code");
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
		List<Country> countries = (List<Country>)context.getBean("countryList"); 
		LOGGER.debug("Country : {}", countries.toString());
		
		Country countryMatched = null;
		for(Country country: countries)
		{
			if(country.getCode().equalsIgnoreCase(code))
			{
				countryMatched = country;
				break;
			}
		}
		((Closeable)context).close();
		if(countryMatched!=null)
			return countryMatched;
		else
			throw new CountryNotFoundException();
	}
	
}
