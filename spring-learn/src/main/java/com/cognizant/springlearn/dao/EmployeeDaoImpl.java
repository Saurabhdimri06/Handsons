package com.cognizant.springlearn.dao;

import java.util.List;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.cognizant.springlearn.model.Employee;
import com.cognizant.springlearn.service.exception.EmployeeNotFoundException;

public class EmployeeDaoImpl implements EmployeeDao {

	private static List<Employee> EMPLOYEE_LIST;
	
	public EmployeeDaoImpl() {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("employee.xml");
		EMPLOYEE_LIST = (List<Employee>)ctx.getBean("employeeList");
		ctx.close();
	}
	
	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		
		return EMPLOYEE_LIST;
	}

	@Override
	public void updateEmployee(Employee emp) throws EmployeeNotFoundException {
		// TODO Auto-generated method stub
		boolean modify = false;
		int index = -1;
		for(Employee employee : EMPLOYEE_LIST) {
			if(employee.getId() == emp.getId()) {
				modify = true;
				index = EMPLOYEE_LIST.indexOf(employee);
				break;
			}
		}
		
		if(modify) {
			EMPLOYEE_LIST.set(index, emp);
		}
		else throw new EmployeeNotFoundException();
	}

	@Override
	public void deleteEmployee(int id) throws EmployeeNotFoundException {
		// TODO Auto-generated method stub
		boolean delete = false;
		int index = -1;
		
		for(Employee emp : EMPLOYEE_LIST) {
			if(emp.getId() == id) {
				delete = true;
				index = EMPLOYEE_LIST.indexOf(emp);
				break;
			}
		}
		
		if(delete) {
			EMPLOYEE_LIST.remove(index);
		} else throw new EmployeeNotFoundException();
	}
	
	

}
