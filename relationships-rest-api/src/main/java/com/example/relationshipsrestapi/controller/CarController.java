package com.example.relationshipsrestapi.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.relationshipsrestapi.exception.ApiRequestException;
import com.example.relationshipsrestapi.model.Car;
import com.example.relationshipsrestapi.service.CarManager;

@RestController
public class CarController {
	
	private CarManager carManager;
	
	@Autowired
	public CarController(CarManager carManager) {
	this.carManager = carManager;
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

	
	@DeleteMapping("/cars/{id}")
	public void deleteCar(@PathVariable Long id) {
		Car car = carManager.findById(id)
				.orElseThrow(() -> new ApiRequestException("Car not found with id: " + id));
		carManager.delete(car);
	}
}
