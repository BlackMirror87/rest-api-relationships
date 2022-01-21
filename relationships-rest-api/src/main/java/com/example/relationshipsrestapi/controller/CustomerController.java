package com.example.relationshipsrestapi.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.relationshipsrestapi.exception.ApiRequestException;
import com.example.relationshipsrestapi.model.Customer;
import com.example.relationshipsrestapi.service.CustomerManager;

@RestController
public class CustomerController {
	
	private CustomerManager customerManager;
	
	@Autowired
	public CustomerController(CustomerManager customerManager) {
		this.customerManager = customerManager;
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
	
	
	@DeleteMapping("/customers/{id}")
	public void deleteCustomer(@PathVariable Long id) {
		Customer customer = customerManager.findById(id)
				.orElseThrow(() -> new ApiRequestException("Customer not found with id " + id));
		customerManager.delete(customer);
			 
	}

}
