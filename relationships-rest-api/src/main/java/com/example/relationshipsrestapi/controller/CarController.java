package com.example.relationshipsrestapi.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.relationshipsrestapi.exception.ApiRequestException;
import com.example.relationshipsrestapi.model.Car;
import com.example.relationshipsrestapi.model.Customer;
import com.example.relationshipsrestapi.model.Part;
import com.example.relationshipsrestapi.service.CarManager;
import com.example.relationshipsrestapi.service.CustomerManager;
import com.example.relationshipsrestapi.service.PartManager;

@RestController
public class CarController {
	
	private CarManager carManager;
	private CustomerManager customerManager;
	private PartManager partManager;
	
	@Autowired
	public CarController(CarManager carManager, CustomerManager customerManager, PartManager partManager) {
	this.carManager = carManager;
	this.customerManager = customerManager;
	this.partManager = partManager;
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

	
	
	@PutMapping("/cars/{carId}/parts/{partId}")
	public Car addPartToCar(@PathVariable Long carId, @PathVariable Long partId) {
		
		Car car = carManager.findById(carId).get();
		Part part = partManager.findById(partId).get();
		

		car.getParts().add(part); //OK
		//car.addPart(part); OK
		
		return carManager.save(car);
	}
	
	
	
	
//	@PutMapping("/cars/{carId}/customers/{customerId}")
//	public Car assignCarToCustomer(@PathVariable Long carId, @PathVariable Long customerId) {
//		
//		Car car = carManager.findById(carId).get();
//		Customer customer = customerManager.findById(customerId).get();
//		
//		car.setCustomer(customer);
//		
//		return carManager.save(car);
//	}
	
	
	
	
	
	@DeleteMapping("/cars/{id}")
	public void deleteCar(@PathVariable Long id) {
		Car car = carManager.findById(id)
				.orElseThrow(() -> new ApiRequestException("Car not found with id: " + id));
		carManager.delete(car);
	}
}
