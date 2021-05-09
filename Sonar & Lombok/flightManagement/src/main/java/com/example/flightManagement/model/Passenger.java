package com.example.flightManagement.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//@Entity
//@Table(name="passenger")
@Getter @Setter @NoArgsConstructor 
public class Passenger {
	
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@Column(name="p_id")
	private int id;
	
//	@Column(name="p_name")
	private String name;
	
//	@Column(name="p_vip")
	private boolean vip;
	
//	@ManyToOne
//	@JoinColumn(name="p_ft_id")
	private Flight flight;

}
