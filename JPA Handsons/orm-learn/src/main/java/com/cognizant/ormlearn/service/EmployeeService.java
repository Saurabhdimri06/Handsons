package com.cognizant.ormlearn.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.model.Department;
import com.cognizant.ormlearn.model.Employee;
import com.cognizant.ormlearn.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository repo;
	
	@Transactional
	public Employee getId(int id) throws Exception{
		return repo.findById(id).get();
	}
	
	@Transactional
	public void addEmployee(Employee employee) {

		repo.save(employee);
	}
	
	@Transactional
	public void updateEmployee(int id, String name, Department dept) {
		Optional<Employee> res = repo.findById(id);
		Employee emp;
		if(res!=null) {
			emp = res.get();
			emp.setName(name);
			emp.setDepartment(dept);
			repo.save(emp);
		}
	}
	
	//Skill and Employee
	@Transactional
	public Employee getEmployeeSkill(int id) throws Exception{	
		Optional<Employee> employee = repo.findById(id);
		Employee emp = null;
		if (!employee.isPresent()){
			emp = employee.get();
			return emp;
		}
		else return emp;
	}
	
	
	//Day 2 Session 2
	
	@Transactional
	public List<Employee> getPermEmployee(){
		return repo.getAllPermanentEmployees();
	}
	
	@Transactional
	public List<Employee> optiPermEmployee(){
		return repo.optimizedGetAllEmployee();
	}
	
	@Transactional
	public Double getAvgSalary() {
		return repo.getAverageSalary();
	}
	
	@Transactional
	public Double getDeptAvgSalary(int id) {
		return repo.getAverageDeptSalary(id);
	}
	
	@Transactional
	public List<Employee> getAllEmployees_Native(){
		return repo.getAllEmployeesNative();
	}
}
