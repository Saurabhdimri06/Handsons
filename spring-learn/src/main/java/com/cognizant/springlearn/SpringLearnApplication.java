package com.cognizant.springlearn;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory; 
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cognizant.springlearn.model.Country;

@SpringBootApplication
public class SpringLearnApplication {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);
	
	public static void displayDate() throws ParseException {
		
		LOGGER.info("START");
		ApplicationContext context = new ClassPathXmlApplicationContext("date-format.xml");
		SimpleDateFormat format = context.getBean("dateFormat", SimpleDateFormat.class); 
		Date dt1 = format.parse("31/12/2018");
		LOGGER.debug("Date: {}",dt1);
		LOGGER.info("END");
	}
	
	public static void displayCountries() {
		
		LOGGER.info("Fetching Countries");
		
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
		Country country = context.getBean("in",Country.class);
		Country anotherCountry = context.getBean("in",Country.class);
		
		LOGGER.debug("Country: {}",country);
		LOGGER.debug("Another country: {}",anotherCountry);
		LOGGER.debug("Hash: {}",country.hashCode());
		LOGGER.debug("Hash: {}",anotherCountry.hashCode());
		LOGGER.info("END");
	}
	
	private static void displayCountriesList(){
		LOGGER.info("START");
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
		List<Country> countries = (List<Country>)context.getBean("countryList");
		for(Country country : countries)
			LOGGER.debug("Country: {}",country);
		LOGGER.info("END");
	}


	public static void main(String[] args) throws ParseException {
		SpringApplication.run(SpringLearnApplication.class, args);
		displayDate();
		displayCountries();
		displayCountriesList();
	}

}
