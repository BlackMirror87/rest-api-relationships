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
	public CustomerController(CustomerManager customerManager, CarManager carManager, AdressManager adressManager) {
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
	
//	@PostMapping("/customers")
//	public Customer addCustomer(@RequestBody Customer customer) {
//		Customer customer1 = new Customer();
//		customer1.setFirstname(customer.getFirstName());
//		customer1.setLastName(customer.getLastName());
//		customer1.setCars(customer.getCars());
//		customer1.setAdress(customer.getAdress());
//		
//		
//		return customerManager.save(customer1);
//	}

	@PutMapping("/customers/{id}")
	public Customer updateCustomer(@PathVariable Long id, @RequestBody Customer customer) {
		Customer customer1 = customerManager.findById(id)
				.orElseThrow(() -> new ApiRequestException("Customer not found with id " + id));

		customer1.setFirstname(customer.getFirstName());
		customer1.setLastName(customer.getLastName());

		return customerManager.save(customer1);
	}

	@DeleteMapping("/customers")
	public void deleteCustomer(@RequestBody Customer customer) {
		customerManager.delete(customer);
	}

	@DeleteMapping("/customers/{id}")
	public void deleteCustomerById(@PathVariable Long id) {
		Customer customer = customerManager.findById(id)
				.orElseThrow(() -> new ApiRequestException("Customer not found with id " + id));
		customerManager.delete(customer);

	}

}
