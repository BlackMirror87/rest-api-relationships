package com.example.relationshipsrestapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Car {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "brand", columnDefinition = "TEXT", nullable = false)
	private String brand;
	
	@Column(name = "number_plate", columnDefinition = "TEXT", nullable = false, unique = true)
	private String numberPlate;
	
	
	@ManyToOne
	@JoinColumn(name = "customer_id")
	private Customer customer;
	
	
	public Car() {
	}

	
	public Car(String brand, String numberPlate) {
	
		this.brand = brand;
		this.numberPlate = numberPlate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getNumberPlate() {
		return numberPlate;
	}

	public void setNumberPlate(String numberPlate) {
		this.numberPlate = numberPlate;
	}


	public Customer getCustomer() {
		return customer;
	}


	public void setCustomer(Customer customer) {
		this.customer = customer;
	}


//	public void assignCustomer(Customer customer) {
//		this.customer= customer;	
//	}
	
}
