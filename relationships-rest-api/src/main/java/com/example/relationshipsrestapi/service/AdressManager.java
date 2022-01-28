package com.example.relationshipsrestapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.relationshipsrestapi.model.Adress;
import com.example.relationshipsrestapi.repository.AdressRepository;

@Service
public class AdressManager {

	AdressRepository adressRepository;

	@Autowired
	public AdressManager(AdressRepository adressRepository) {
		this.adressRepository = adressRepository;
	};
	
	
	public List<Adress> findAll() {
		return adressRepository.findAll();
	}

	public Optional<Adress> findById(Long id) {
		return adressRepository.findById(id);
	}
	
	public Adress save(Adress adress) {
		return adressRepository.save(adress);
	}
	
	public void delete(Adress adress) {
		adressRepository.delete(adress);
	}
	
	public void deleteById(Long id) {
		adressRepository.deleteById(id);
	}
	
	
	
}
	