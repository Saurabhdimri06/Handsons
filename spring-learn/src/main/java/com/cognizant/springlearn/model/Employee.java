package com.cognizant.springlearn.model;

import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

public class Employee {
	
	@NotNull
	@PositiveOrZero
	private int id;
	
	@NotNull
	@Size(min=1, max=30)
	private String name;
	
	@NotNull
	@PositiveOrZero
	private int age;
	
	@NotNull
	@PositiveOrZero
	private int salary;
	
	@NotNull
	private Department department;
	
	@NotNull
	private List<Skill> skill;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

	
	
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}

	public List<Skill> getSkill() {
		return skill;
	}
	public void setSkill(List<Skill> skill) {
		this.skill = skill;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", age=" + age + ", salary=" + salary + ", department="
				+ department + ", skill=" + skill + "]";
	}
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
