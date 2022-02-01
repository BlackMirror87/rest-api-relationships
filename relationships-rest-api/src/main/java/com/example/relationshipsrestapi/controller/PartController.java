package com.example.relationshipsrestapi.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import javax.websocket.server.PathParam;
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
public class PartController {

	private PartManager partManager;
	private CarManager carManager;

	@Autowired
	public PartController(PartManager partManager, CarManager carManager) {
		this.partManager = partManager;
		this.carManager = carManager;
	}

	@GetMapping("/parts")
	public List<Part> findAll() {
		return partManager.findAll();
	}

	@GetMapping("/parts/{id}")
	public Optional<Part> findById(@PathVariable Long id) {
		Part part = partManager.findById(id)
				.orElseThrow(() -> new ApiRequestException("Part not found with id: " + id));
		return partManager.findById(id);
	}

	@PostMapping("/parts")
	public Part addPart(@RequestBody Part part) {
		return partManager.save(part);
	}
	
	@PutMapping("/parts/{id}")
	public Part updatePart(@PathVariable Long id, @RequestBody Part part) {
		Part part1 = partManager.findById(id)
				.orElseThrow(() -> new ApiRequestException("Part not found with id: " + id));
		part1.setPartName(part.getPartName());
		part1.setPrice(part.getPrice());
		
		return partManager.save(part1);
	}

	@DeleteMapping("/parts")
	public void delete(@RequestBody Part part) {
		partManager.delete(part);
	}

	@DeleteMapping("/parts/{id}")
	public void deleteById(@PathVariable Long id) {
		Part part = partManager.findById(id)
				.orElseThrow(() -> new ApiRequestException("Part not found with id: " + id));
		partManager.deleteById(id);
	}

}
