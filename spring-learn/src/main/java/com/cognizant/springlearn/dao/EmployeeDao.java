package com.cognizant.springlearn.dao;

import java.util.List;

import com.cognizant.springlearn.model.Employee;
import com.cognizant.springlearn.service.exception.EmployeeNotFoundException;

public interface EmployeeDao {
	
	public List<Employee> getAllEmployees();
	public void updateEmployee(Employee emp) throws EmployeeNotFoundException;
	public void deleteEmployee(int id) throws EmployeeNotFoundException;
}
