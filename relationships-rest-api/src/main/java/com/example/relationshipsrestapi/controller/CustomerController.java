package com.example.relationshipsrestapi.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.relationshipsrestapi.exception.ApiRequestException;
import com.example.relationshipsrestapi.model.Adress;
import com.example.relationshipsrestapi.model.Car;
import com.example.relationshipsrestapi.model.Customer;
import com.example.relationshipsrestapi.service.AdressManager;
import com.example.relationshipsrestapi.service.CarManager;
import com.example.relationshipsrestapi.service.CustomerManager;

@RestController
public class CustomerController {

	private CustomerManager customerManager;
	private CarManager carManager;
	private AdressManager adressManager;

	@Autowired
	public CustomerController(CustomerManager customerManager, CarManager carManager,
			AdressManager adressManager) {
		this.customerManager = customerManager;
		this.carManager = carManager;
		this.adressManager = adressManager;
	}

	
	@GetMapping("/customers")
	public List<Customer> getCustomers() {
		return customerManager.findAll();
	}

	
	@GetMapping("/customers/{id}")
	public Customer getCustomerById(@PathVariable Long id) {
		return customerManager.findById(id)
				.orElseThrow(() -> new ApiRequestException("Customer not found with id " + id));
	}

	
	@PostMapping("/customers")
	public Customer addCustomer(@RequestBody Customer customer) {
		return customerManager.save(customer);
	}
	
	
	@PutMapping("/customers/{customerId}/adress/{adressId}")
	public Customer assignAdressToCustomer(@PathVariable Long customerId, @PathVariable Long adressId) {
		
		Customer customer = customerManager.findById(customerId).get();
		Adress adress = adressManager.findById(adressId).get();
		
		customer.setAdress(adress);
		return customerManager.save(customer);
	}
	

	@DeleteMapping("/customers/{id}")
	public void deleteCustomer(@PathVariable Long id) {
		Customer customer = customerManager.findById(id)
				.orElseThrow(() -> new ApiRequestException("Customer not found with id " + id));
		customerManager.delete(customer);

	}

}
