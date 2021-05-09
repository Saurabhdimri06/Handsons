package com.example.flightManagement.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.flightManagement.model.Flight;
import com.example.flightManagement.repository.FlightRepository;

@Service
public class FlightService {
	
	@Autowired
	private FlightRepository repo;
	
	@Transactional
	public void addFlight(Flight flight) {
		repo.save(flight);
	}
	
	public void deleteFlight(int id) {
		repo.deleteById(id);
	}
}
