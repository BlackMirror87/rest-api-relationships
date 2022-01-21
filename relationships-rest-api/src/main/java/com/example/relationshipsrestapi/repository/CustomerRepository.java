package com.example.relationshipsrestapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.relationshipsrestapi.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
	
}
