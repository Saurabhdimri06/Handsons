package com.cognizant.ormlearn.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="skill")
public class Skill {

	@Id
	@Column(name="sk_id")
	private int id;
	
	@Override
	public String toString() {
		return "Skill [id=" + id + ", name=" + name + ", employeeList=" + employeeList + "]";
	}

	@Column(name="sk_name")
	private String name;

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

	public Skill() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Skill(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	 @ManyToMany(mappedBy = "skillList",  fetch = FetchType.EAGER)
	 private Set<Employee> employeeList; 
	
}
