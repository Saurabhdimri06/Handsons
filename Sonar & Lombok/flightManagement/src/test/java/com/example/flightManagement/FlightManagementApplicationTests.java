package com.example.flightManagement;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.flightManagement.model.Flight;
import com.example.flightManagement.model.Passenger;
import com.example.flightManagement.service.FlightService;
import com.example.flightManagement.service.PassengerService;

@SpringBootTest
class FlightManagementApplicationTests {

	@Test
	void contextLoads() {
	}
	
//	@InjectMocks
//	private Passenger p;
//	private Flight f;
	
//	@Mock private PassengerService pService;
//	@Mock private FlightService fService;
//	
	private PassengerService pService;
	private FlightService fService;
	
	@Test
	public void addPassengerTest() {
		Passenger p = new Passenger();
		pService.addPassenger(p);
		List<Flight> list = new ArrayList<Flight>();
        Flight cOne = new Flight();
        Flight cTwo = new Flight();
        
        list.add(cOne);
        list.add(cTwo);
        
		assertEquals(2, list.size());
		verify(pService, times(1)).addPassenger(p);
	}
	
	@Test
	public void addFlightTest() {
		Flight f = new Flight();
		fService.addFlight(f);
		verify(fService, times(1)).addFlight(f);
	}
	
	@Test
	public void removePassengerTest() {
		Passenger p = new Passenger();
		pService.removePassenger(p);
		verify(pService, times(1)).removePassenger(p);
	}
	


}
