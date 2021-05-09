package com.cognizant.ormlearn.service;

import java.util.List;
import java.util.Optional;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.ormlearn.OrmLearnApplication;
import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.repository.CountryRepository;

@Service
public class CountryService {
	private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);
	
	@Autowired
	private CountryRepository countryRepository;
	
	@Transactional
	public List<Country> getAllCountries() {
		return countryRepository.findAll();
		
	}
	
	
	@Transactional
	public void addCountry(Country country) throws Exception {
		
		LOGGER.info("start");
		countryRepository.save(country);
		//Country res = findCountryByCode(country.getCode());
		//LOGGER.debug("res response" , res.get());
//		if(res == null) {
//			
//			
//			LOGGER.debug("country", country);
//			
//		}
		LOGGER.info("end");
    }

	@Transactional
	public Country findCountryByCode(String countryCode) throws Exception{
		Optional<Country> result = countryRepository.findById(countryCode);
		Country country = null;
		if (!result.isPresent()){
			country = result.get();
			return country;
		}
		else return country;

	}
	
	@Transactional
	public void updateCountry(String code, String name) throws Exception{
		Optional<Country> res = countryRepository.findById(code);
		Country country;
		if(res!=null) {
			country = res.get();
			country.setName(name);
			countryRepository.save(country);
		}
		
	}
	
	@Transactional
	public void deleteCountry(String code) {
		countryRepository.deleteById(code);
	}
	
	
	
	
	/* Day 2 Queries */
	
	@Transactional
	public List<Country> findCountryLike(String s) {
		
		List<Country> clist =  countryRepository.findByNameLike(s);
		return clist;
	}
	
	@Transactional
	public List<Country> findByLetter(String s){
		
		List<Country> clist = countryRepository.findByNameStartingWith(s);
		return clist;
	}
	
}