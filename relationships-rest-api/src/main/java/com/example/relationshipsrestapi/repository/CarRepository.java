package com.example.relationshipsrestapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.relationshipsrestapi.model.Car;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {	
}
