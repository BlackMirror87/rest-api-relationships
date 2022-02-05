package com.example.relationshipsrestapi.model;

import java.util.*;
import javax.persistence.*;
import javax.transaction.Transactional;

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

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinTable(name = "customer_car", joinColumns = @JoinColumn(name = "car_id"), inverseJoinColumns = @JoinColumn(name = "customer_id"))
	private Customer customer;

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "car_part", joinColumns = @JoinColumn(name = "car_id"), inverseJoinColumns = @JoinColumn(name = "part_id"))
	private Set<Part> parts = new HashSet<>();

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

	public Set<Part> getParts() {
		return parts;
	}

	public void setParts(Set<Part> parts) {
		this.parts = parts;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public void addPart(Part part) {
		this.parts.add(part);
	}

}
