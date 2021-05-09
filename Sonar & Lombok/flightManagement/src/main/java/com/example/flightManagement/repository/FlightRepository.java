package com.example.flightManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.flightManagement.model.Flight;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Integer>{

}
