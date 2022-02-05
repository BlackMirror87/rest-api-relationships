package com.example.relationshipsrestapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.relationshipsrestapi.model.Car;
import com.example.relationshipsrestapi.repository.CarRepository;

@Service
public class CarManager {

	CarRepository carRepository;

	@Autowired
	public CarManager(CarRepository carRepository) {
		this.carRepository = carRepository;
	}

	public List<Car> findAll() {
		return carRepository.findAll();
	}

	public Optional<Car> findById(Long id) {
		return carRepository.findById(id);
	}

	public Car save(Car car) {
		return carRepository.save(car);
	}

	public void delete(Car car) {
		carRepository.delete(car);
	}

	public void deleteById(Long id) {
		carRepository.deleteById(id);
	}

}
