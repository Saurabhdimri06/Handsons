package com.cognizant.ormlearn.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="employee")
public class Employee {

	 @ManyToOne
	 @JoinColumn(name = "em_dp_id")
	 private Department department; 
	
	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="em_id")
	private int id;
	
	@Column(name="em_name")
	private String name;
	
	@Column(name="em_salary")
	private double salary;
	
	@Column(name="em_permanent")
	private boolean permanent;
	
	@Column(name="em_date_of_birth")
	private Date dob;
	
	 @ManyToMany(fetch = FetchType.EAGER)
	 @JoinTable(name = "employee_skill",
	 joinColumns = @JoinColumn(name = "es_em_id"),
	 inverseJoinColumns = @JoinColumn(name = "es_sk_id"))
	 private Set<Skill> skillList; 
	 
	public Set<Skill> getSkillList() {
		return skillList;
	}

	public void setSkillList(Set<Skill> skillList) {
		this.skillList = skillList;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public boolean isPermanent() {
		return permanent;
	}

	public void setPermanent(boolean permanent) {
		this.permanent = permanent;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	

	public Employee(Department department, int id, String name, double salary, boolean permanent, Date dob) {
		super();
		this.department = department;
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.permanent = permanent;
		this.dob = dob;
	}

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
