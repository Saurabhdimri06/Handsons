package com.example.flightManagement.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.flightManagement.model.Passenger;
import com.example.flightManagement.repository.PassengerRepository;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class PassengerService {
	
	@Autowired
	private PassengerRepository repo;
	
	@Transactional
	public void addPassenger(Passenger passenger) {
		repo.save(passenger);
	}
	
	@Transactional
	public void removePassenger(Passenger p) {
		repo.delete(p);
	}

}
