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
		return carManager.findById(id).orElseThrow(() -> new ApiRequestException("Car not found with id: " + id));
	}

	@PostMapping("/cars")
	public Car addCar(@RequestBody Car car) {
		Car car1= new Car();
		car1.setBrand(car.getBrand());
		car1.setNumberPlate(car.getNumberPlate());
		car1.setParts(car.getParts());
		
		return carManager.save(car1);
	}

	// version 1 - works
	@PostMapping("/customers/{customerId}/cars")
	public Car addCar(@PathVariable Long customerId, @RequestBody Car car) {
		Customer customer = customerManager.findById(customerId).get();
		car.setCustomer(customer);
		return carManager.save(car);
	}

	// version 2 with utility methods gets LazyInitializationException
//	@PostMapping("/customers/{customerId}/cars")
//	public Car addCar(@PathVariable Long customerId, @RequestBody Car car) {
//		Customer customer = customerManager.findById(customerId).get();
//		customer.addCar(car);
//		return carManager.save(car);
//	}

	@PutMapping("cars/{id}")
	public Car updateCar(@PathVariable Long id, @RequestBody Car car) {
		Car car1 = carManager.findById(id).orElseThrow(() -> new ApiRequestException("Car not found with id: " + id));

		car1.setBrand(car.getBrand());
		car1.setNumberPlate(car.getNumberPlate());

		return carManager.save(car1);
	}

	@DeleteMapping("/cars")
	public void deleteCar(@RequestBody Car car) {
		carManager.delete(car);
	}

	@DeleteMapping("/cars/{id}")
	public void deleteCarById(@PathVariable Long id) {
		Car car = carManager.findById(id).orElseThrow(() -> new ApiRequestException("Car not found with id: " + id));
		carManager.delete(car);
	}
}
