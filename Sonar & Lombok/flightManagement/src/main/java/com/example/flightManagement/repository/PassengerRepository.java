package com.example.flightManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.flightManagement.model.Passenger;

@Repository
public interface PassengerRepository extends JpaRepository<Passenger, String> {

}
