package com.example.relationshipsrestapi.model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "parts")
public class Part {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "part_name", columnDefinition = "TEXT", nullable = false)
	private String partName;
	
	@Column(name = "price", columnDefinition = "TEXT", nullable = false)
	private String price;
	
	@JsonIgnore
	@ManyToMany(mappedBy = "parts")
	private Set<Car> cars = new HashSet<>();
	
	
		
	public Part() {
	}
	
	public Part(String partName, String price) {
		this.partName = partName;
		this.price = price;
	}
	
	public String getPartName() {
		return partName;
	}
	
	public void setPartName(String partName) {
		this.partName = partName;
	}
	
	public String getPrice() {
		return price;
	}
	
	public void setPrice(String price) {
		this.price = price;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Set<Car> getCars() {
		return cars;
	}
	
	public void setCars(Set<Car> cars) {
		this.cars = cars;
	}
	
	public void addCar (Car car) {
		this.cars.add(car);
	}
}
