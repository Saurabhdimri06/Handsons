package com.cognizant.ormlearn;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.model.Department;
import com.cognizant.ormlearn.model.Employee;
import com.cognizant.ormlearn.model.Skill;
import com.cognizant.ormlearn.model.Stock;
import com.cognizant.ormlearn.service.CountryService;
import com.cognizant.ormlearn.service.DepartmentService;
import com.cognizant.ormlearn.service.EmployeeService;
import com.cognizant.ormlearn.service.SkillService;
import com.cognizant.ormlearn.service.StockService;

@SpringBootApplication
public class OrmLearnApplication {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);
	
	public static CountryService countryService;
	public static StockService stockService;
	public static EmployeeService empService;
	public static DepartmentService deptService;
	public static SkillService skillService;
	
	public static void testGetAllCountries() {
		LOGGER.info("Start");
		List<Country> countries = countryService.getAllCountries();
		LOGGER.debug("countries={}", countries);
		LOGGER.info("End");
	}
	
	public static void testAddCountry() throws Exception {
		LOGGER.info("Start");
		countryService.addCountry(new Country("ZZ", "Location 1"));
		countryService.addCountry(new Country("ZM", "ABC"));
		countryService.addCountry(new Country("IN", "India"));
		LOGGER.info("End");
	}

	private static void getAllCountriesTest() throws Exception {

		LOGGER.info("Start");
		Country country = countryService.findCountryByCode("ZM");
		LOGGER.debug("Country:{}", country);
		LOGGER.info("End");
	
	}
	
	private static void doUpdateCountry() throws Exception{
		LOGGER.info("Start");
		countryService.updateCountry("ZM", "Zambia");
		LOGGER.info("End");
	}
	
	private static void doDeleteCountry() throws Exception{
		LOGGER.info("Start");
		countryService.deleteCountry("ZZ");
		LOGGER.info("End");
	}
	
	
	//Day 2 Handson
	
	private static void findCountryLike() {
		LOGGER.info("Start");
		List<Country> c = countryService.findCountryLike("%ou%");
		LOGGER.debug("Country:{}", c);
		LOGGER.info("End");
	}
	
	private static void findByLetter() {
		LOGGER.info("Start");
		List<Country> c = countryService.findCountryLike("Z%");
		LOGGER.debug("Country:{}", c);
		LOGGER.info("End");
	}
	
	//STOCKS
	private static void findStocksByDate() throws Exception {
		LOGGER.info("Start");
		String start = "2019/09/15";
	    String end = "2019/09/17";

	    Date d1 = null;
	    Date d2 = null;
	    try {
	        d1 = new SimpleDateFormat("yyyy/MM/dd").parse(start);
	        d2 = new SimpleDateFormat("yyyy/MM/dd").parse(end);
	        
	    } catch (ParseException e) {
	        e.printStackTrace();
	    }
		
	    List<Stock> s = stockService.findStocks(d1, d2);
        LOGGER.debug("Stocks:{}", s);
		LOGGER.info("End");
	}
	
	private static void findStocksGreaterThan() {
		LOGGER.info("Start");
		List<Stock> st = stockService.checkStockValue(187.0);
		LOGGER.debug("Stocks Found {}", st);
		LOGGER.info("End");
	}
	
	public static void findTopThreeStocks() {
		LOGGER.info("Start");
		List<Stock> st = stockService.topThreeStocksDate();
		LOGGER.debug("Stocks Found {}", st);
		LOGGER.info("End");
	}
	
	public static void findBotThreeStocks() {
		LOGGER.info("Start");
		List<Stock> st = stockService.botThreeStocksClose();
		LOGGER.debug("Stocks Found {}", st);
		LOGGER.info("End");
	}
	
	//EMPLOYEE
	public static void getEmployeeById() throws Exception {
		LOGGER.info("Start");
		Employee emp = empService.getId(1);
		LOGGER.info("End");
	}
	
	public static void addNewEmployee() {
		LOGGER.info("Start");
//		empService.addEmployee(new Employee(4, 6, "Anirudh", 100000.61, true, null));
		LOGGER.info("END");
	}
	
	private static void testGetEmployee() throws Exception {

		LOGGER.info("Start");
		Employee employee = empService.getId(1);
		LOGGER.debug("Employee:{}", employee);
		LOGGER.info("End");
		}
	
	private static void testUpdateEmployee() throws Exception{
		LOGGER.info("Start");
		Department dept = new Department(5, "singing");
		empService.updateEmployee(2, "Saurabh", dept);
		LOGGER.info("End");
	}
	
	//Skill
	public static void getEmployeeSkill() throws Exception{
		LOGGER.info("Start");
		Employee employee = empService.getId(1);
		LOGGER.debug("Skills:{}", employee.getSkillList()); 
		LOGGER.info("End");
	}
	
	private static void testAddSkillToEmployee() throws Exception {
		Employee employee = empService.getId(1);
		Skill skill = skillService.get(3);
		Set<Skill> skillList = employee.getSkillList();
		skillList.add(skill);
		empService.addEmployee(employee);
		LOGGER.debug(employee.toString());
	}
	
	//Day2 Session 2
	public static void getAllEmpHQL() {
		LOGGER.info("Start");
		List<Employee> employees = empService.getPermEmployee();
		LOGGER.debug("Permanent Employees:{}", employees);
		employees.forEach(e -> LOGGER.debug("Skills:{}", e.getSkillList()));
		LOGGER.info("End");

	}
	
	public static void optimizedPermEmployee() {
		LOGGER.info("Start");
		List<Employee> employees = empService.optiPermEmployee();
		LOGGER.debug("Permanent Employees:{}", employees);
		employees.forEach(e -> LOGGER.debug("Skills:{}", e.getSkillList()));
		LOGGER.info("End");
		
	}
	
	public static void getAvgSalary() {
		LOGGER.info("Start");
		Double sal = empService.getAvgSalary();
		LOGGER.debug("Average Salary:", sal );
		LOGGER.info("End");
	}
	
	public static void getDeptAvgSalary() {
		LOGGER.info("Start");
		Double deptsal = empService.getDeptAvgSalary(5);
		LOGGER.debug("Average Salary:", deptsal );
		LOGGER.info("End");
	}
	
	public static void getNativeEmployees() {
		LOGGER.info("Start");
		List<Employee> emp = empService.getAllEmployees_Native();
		LOGGER.debug("Employees : {}", emp); 
		LOGGER.info("End");
	}
	
	public static void main(String[] args) throws Exception {
		
		ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);
		LOGGER.info("Inside main");
		countryService = context.getBean(CountryService.class);
		stockService = context.getBean(StockService.class);
		empService = context.getBean(EmployeeService.class);
		deptService = context.getBean(DepartmentService.class);
		skillService = context.getBean(SkillService.class);
		
		
		testGetAllCountries();
		testAddCountry();
		getAllCountriesTest();
		doUpdateCountry();
		doDeleteCountry();
		
		//Day2
		findCountryLike();
		findByLetter();
		
		//Stocks
		findStocksByDate();
		findStocksGreaterThan();
		findTopThreeStocks();
		findBotThreeStocks();
		
		//Employee
		getEmployeeById();
		addNewEmployee();
		testGetEmployee();
		testUpdateEmployee();
		
		
		//Skill
		getEmployeeSkill();
		testAddSkillToEmployee();
		
		//HQL
		getAllEmpHQL();
		optimizedPermEmployee();
		getAvgSalary();
		getDeptAvgSalary();
		getNativeEmployees();
		
	}


}
