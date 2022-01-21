package com.example.relationshipsrestapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.relationshipsrestapi.model.Customer;
import com.example.relationshipsrestapi.repository.CustomerRepository;

@Service
public class CustomerManager {

	CustomerRepository customerRepository;

	@Autowired
	public CustomerManager(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}
	
	public List<Customer> findAll() {
		return customerRepository.findAll();
	}
	
	public Optional<Customer> findById(Long id) {
		return customerRepository.findById(id);
	}
	
	public Customer save(Customer customer) {
		return customerRepository.save(customer);
	}
	
	public void delete(Customer customer) {
		customerRepository.delete(customer);
	}
	
	public void deleteById(Long id) {
		customerRepository.deleteById(id);
	}
}
