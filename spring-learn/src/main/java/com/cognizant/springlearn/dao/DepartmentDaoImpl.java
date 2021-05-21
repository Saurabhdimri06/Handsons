package com.cognizant.springlearn.dao;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cognizant.springlearn.model.Department;
import com.cognizant.springlearn.model.Employee;

public class DepartmentDaoImpl implements DepartmentDao{

	private static List<Department> DEPARTMENT_LIST;
	public DepartmentDaoImpl() {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("employee.xml");
		DEPARTMENT_LIST = (List<Department>)ctx.getBean("departmentList");
		ctx.close();
	}
	
	@Override
	public List<Department> getAllDepartment() {
		// TODO Auto-generated method stub
		return DEPARTMENT_LIST;
	}

}
