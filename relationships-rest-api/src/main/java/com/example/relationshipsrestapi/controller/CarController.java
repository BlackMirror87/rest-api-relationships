package com.example.relationshipsrestapi.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.relationshipsrestapi.exception.ApiRequestException;
import com.example.relationshipsrestapi.model.Car;
import com.example.relationshipsrestapi.model.Customer;
import com.example.relationshipsrestapi.service.CarManager;
import com.example.relationshipsrestapi.service.CustomerManager;

@RestController
public class CarController {
	
	private CarManager carManager;
	private CustomerManager customerManager;
	
	@Autowired
	public CarController(CarManager carManager, CustomerManager customerManager) {
	this.carManager = carManager;
	this.customerManager = customerManager;
	}

	
	@GetMapping("/cars")
	public List<Car> getCars() {
		return carManager.findAll();
	}
	
	
	@GetMapping("/cars/{id}")
	public Car getCarById(@PathVariable Long id) {
		return carManager.findById(id)
				.orElseThrow(() -> new ApiRequestException("Car not found with id: " + id));
	}
	
	
	@PostMapping("/cars")
	public Car addCar(@RequestBody Car car) {
		return carManager.save(car);
	}

	
	@PutMapping("customers/{customerId}/cars/{carId}")
	public Car assignCarToCustomer(@PathVariable Long carId, @PathVariable Long customerId) {
		
		Car car = carManager.findById(carId).get();
		Customer customer = customerManager.findById(customerId).get();
		
		car.assignCustomer(customer);
		//HashSet<Car> cars = new HashSet<>();
		//cars.add(car);
		//customer.assignCars(cars);
		
		return carManager.save(car);
	}
	
	
	
	@DeleteMapping("/cars/{id}")
	public void deleteCar(@PathVariable Long id) {
		Car car = carManager.findById(id)
				.orElseThrow(() -> new ApiRequestException("Car not found with id: " + id));
		carManager.delete(car);
	}
}
