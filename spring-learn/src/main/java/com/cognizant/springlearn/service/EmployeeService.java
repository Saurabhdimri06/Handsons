package com.cognizant.springlearn.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cognizant.springlearn.dao.EmployeeDao;
import com.cognizant.springlearn.dao.EmployeeDaoImpl;
import com.cognizant.springlearn.model.Employee;
import com.cognizant.springlearn.service.exception.EmployeeNotFoundException;

@Service
public class EmployeeService {

	private EmployeeDao dao = new EmployeeDaoImpl();
	
	public List<Employee> getAllEmployees(){
		return dao.getAllEmployees();
	}
	
	public void updateEmployee(Employee emp) throws EmployeeNotFoundException {
		dao.updateEmployee(emp);
	}
	
	public void deleteEmployee(int id) throws EmployeeNotFoundException {
		dao.deleteEmployee(id);
	}
}

