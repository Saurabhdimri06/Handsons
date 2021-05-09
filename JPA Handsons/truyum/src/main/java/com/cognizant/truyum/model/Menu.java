package com.cognizant.truyum.model;

import java.util.Date;
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
@Table(name="menu")
public class Menu {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="m_id")
	private int id;
	
	@Column(name="m_name")
	private String name;
	
	@Column(name="m_price")
	private float price;
	
	@Column(name="m_active")
	private boolean active;
	
	@Column(name="m_date")
	private Date date;
	
	@Column(name="m_category")
	private String category;
	
	@Column(name="m_delivery")
	private boolean delivery;
	
	@OneToMany(mappedBy="menu", fetch=FetchType.EAGER)
	private List<Cart> carts;
	
	public List<Cart> getCarts() {
		return carts;
	}

	public void setCarts(List<Cart> carts) {
		this.carts = carts;
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

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public boolean isDelivery() {
		return delivery;
	}

	public void setDelivery(boolean delivery) {
		this.delivery = delivery;
	}

	

	@Override
	public String toString() {
		return "Menu [id=" + id + ", name=" + name + ", price=" + price + ", active=" + active + ", date=" + date
				+ ", category=" + category + ", delivery=" + delivery + ", carts=" + carts + "]";
	}

	public Menu() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Menu(int id, String name, float price, boolean active, Date date, String category, boolean delivery) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.active = active;
		this.date = date;
		this.category = category;
		this.delivery = delivery;
	}
	
	
}
