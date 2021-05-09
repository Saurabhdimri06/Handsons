package com.cognizant.ormlearn;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.model.Employee;
import com.cognizant.ormlearn.service.CountryService;
import com.cognizant.ormlearn.service.EmployeeService;

//import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
class OrmLearnApplicationTests {

	@Test
	void contextLoads() {
	}
	
	@InjectMocks
	Country country;
	Employee emp;
	
	@Mock
	CountryService service;
	EmployeeService empService;
	
	@Test
    public void getAllCountriesTest()
    {
        List<Country> list = new ArrayList<Country>();
        Country cOne = new Country("JH", "Jordan");
        Country cTwo = new Country("KK", "kolenchiski");

        list.add(cOne);
        list.add(cTwo);
        
        when(service.getAllCountries()).thenReturn(list);
         
        //test
        List<Country> cList = service.getAllCountries();
         
        assertEquals(2, cList.size());
        verify(service, times(1)).getAllCountries();
    }
	
	@Test
	public void addCountryTest() throws Exception {
		
		Country c = new Country("KK" , "New KKK Land");
		service.addCountry(c);
		verify(service, times(1)).addCountry(c);
	}
	
	@Test
	public void addEmployeeTest() throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date date = sdf.parse("1992-07-26");
		Employee e = new Employee(null, 6, "ShantiLaL", 20000, true, date);
		
		empService.addEmployee(e);
		verify(empService, times(1)).addEmployee(e);
		
	}

}
