package com.example.relationshipsrestapi.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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
	public List<Adress> getAdresses(){
		return adressManager.findAll();
	}
	
	
	@GetMapping("/adress/{id}")
	public Optional<Adress> getAdress(@PathVariable Long id) {
		return adressManager.findById(id);
	}
	
	
	@PostMapping("/adress")
	public Adress addAdress(@RequestBody Adress adress) {
		return adressManager.save(adress);
	}
	
	@DeleteMapping("/adress")
	public void deleteAdress(@RequestBody Adress adress) {
		adressManager.delete(adress);
	}
	
	
	@DeleteMapping("/adress/{id}")
	public void deleteAdressById(@PathVariable Long id) {
		adressManager.deleteById(id);
	}
	
	
}
