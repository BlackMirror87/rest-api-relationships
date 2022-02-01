package com.example.relationshipsrestapi.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "adress")
public class Adress {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "phone", columnDefinition = "TEXT", nullable = false)
	private String phone;
	
	@Column(name = "street", columnDefinition = "TEXT", nullable = false)
	private String street;
	
	@Column(name = "city", columnDefinition = "TEXT", nullable = false)
	private String city;
	
	@JsonIgnore
	@OneToOne(mappedBy = "adress")
	private Customer customer;
	
	

	public Adress() {
	}
	
	public Adress(Long id, String phone, String street, String city) {
		this.id = id;
		this.phone = phone;
		this.street = street;
		this.city = city;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

}
