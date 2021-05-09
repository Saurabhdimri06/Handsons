package com.cognizant.truyum.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="us_id")
	private int userId;
	
	@Column(name="us_name")
	private String name;
	
	@OneToMany(mappedBy="user", fetch=FetchType.EAGER)
	private List<Cart> carts;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Cart> getCarts() {
		return carts;
	}

	public void setCarts(List<Cart> carts) {
		this.carts = carts;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name + ", carts=" + carts + "]";
	}

	public User(int userId, String name, List<Cart> carts) {
		super();
		this.userId = userId;
		this.name = name;
		this.carts = carts;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
