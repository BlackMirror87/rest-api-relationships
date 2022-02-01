package com.example.relationshipsrestapi.model;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "customer")
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "first_name", columnDefinition = "TEXT", nullable = false)
	private String firstName;
	
	@Column(name = "last_name", columnDefinition = "TEXT", nullable = false)
	private String lastName;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "adress_id", referencedColumnName = "id")
	private Adress adress;
	
	
	@JsonIgnore
	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Car> cars = new HashSet<Car>();
	
	
	public Customer() {
	}

	public Customer(String firstName, String lastName) {
		
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstname(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public Set<Car> getCars() {
		return cars;
	}


	public void setCars(Set<Car> cars) {
		this.cars = cars;
	}

	public Adress getAdress() {
		return adress;
	}

	public void setAdress(Adress adress) {
		this.adress = adress;
	}
	
	public void addCar(Car car) {
		cars.add(car);
		car.setCustomer(this);
	}
	
	public void removeCar(Car car) {
		cars.remove(car);
		car.setCustomer(null);
	}
}
