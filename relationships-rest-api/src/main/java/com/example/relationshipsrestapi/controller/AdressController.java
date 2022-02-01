package com.example.relationshipsrestapi.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.relationshipsrestapi.exception.ApiRequestException;
import com.example.relationshipsrestapi.model.Adress;
import com.example.relationshipsrestapi.service.AdressManager;

@RestController
public class AdressController {

	AdressManager adressManager;

	@Autowired
	public AdressController(AdressManager adressManager) {
		this.adressManager = adressManager;
	}

	@GetMapping("/adress")
	public List<Adress> getAdresses() {
		return adressManager.findAll();
	}

	@GetMapping("/adress/{id}")
	public Adress getAdress(@PathVariable Long id) {
		return adressManager.findById(id).orElseThrow(() -> new ApiRequestException("adress not found with id " + id));
	}

	@PutMapping("/adress/{id}")
	public Adress updateAdress(@PathVariable Long id, @RequestBody Adress adress) {
		Adress adress1 = adressManager.findById(id)
				.orElseThrow(() -> new ApiRequestException("adress not found with id " + id));

		adress1.setCity(adress.getCity());
		adress1.setPhone(adress.getPhone());
		adress1.setStreet(adress.getStreet());

		return adressManager.save(adress1);
	}

	@DeleteMapping("/adress")
	public void deleteAdress(@RequestBody Adress adress) {
		adressManager.delete(adress);
	}

	@DeleteMapping("/adress/{id}")
	public void deleteAdressById(@PathVariable Long id) {
		Adress adress = adressManager.findById(id)
				.orElseThrow(() -> new ApiRequestException("adress not found with id " + id));
		adressManager.delete(adress);
	}

}
