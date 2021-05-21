package com.cognizant.springlearn.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cognizant.springlearn.dao.DepartmentDao;
import com.cognizant.springlearn.dao.DepartmentDaoImpl;
import com.cognizant.springlearn.model.Department;

@Service
public class DepartmentService {

	DepartmentDao dao = new DepartmentDaoImpl();
	
	public List<Department> getAllDepartment(){
		return dao.getAllDepartment();
	}
	
}
