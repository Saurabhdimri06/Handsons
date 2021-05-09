package com.example.flightManagement.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import com.example.flightManagement.model.Passenger;

//@Entity
//@Table(name="flight")
@Getter @Setter @NoArgsConstructor
public class Flight {

	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@Column(name="f_id")
	private int id;
	
//	@Column(name="f_name")
	private String name;
	
//	@OneToMany(mappedBy="user", fetch=FetchType.EAGER)
	private List<Passenger> passenger;
}
