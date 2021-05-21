package com.cognizant.springlearn.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cognizant.springlearn.model.Employee;

import com.cognizant.springlearn.service.EmployeeService;
import com.cognizant.springlearn.service.exception.EmployeeNotFoundException;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/employee")
@Api(value="employee", description="Handels All Employees Operations (Adding, Deleting and Updating)")
public class EmployeeController {

	@Autowired
	private EmployeeService service;
	
	@GetMapping("/get")
	public List<Employee> getAllEmployees(){
		return service.getAllEmployees();
	}
	
	@PutMapping("/update")
	public void updateEmployee(@RequestBody @Valid Employee emp) throws EmployeeNotFoundException{
		service.updateEmployee(emp);
	}
	
	@DeleteMapping("delete/{id}")
	public void deleteEmployee(@PathVariable("id") int id) throws EmployeeNotFoundException {
		service.deleteEmployee(id);
	}
	
}
