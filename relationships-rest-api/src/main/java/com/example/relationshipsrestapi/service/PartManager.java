package com.example.relationshipsrestapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.relationshipsrestapi.model.Part;
import com.example.relationshipsrestapi.repository.PartRepository;

@Service
public class PartManager {
	
	PartRepository partRepository;
	
	@Autowired
	public PartManager(PartRepository partRepository) {
		this.partRepository = partRepository;
	}


	public List<Part> findAll() {
		return partRepository.findAll();
	}
	
	public Optional<Part> findById(Long id) {
		return partRepository.findById(id);
	}
	
	
	public Part save(Part part) {
		return partRepository.save(part);
	}
	
	
	public void delete(Part part) {
		partRepository.delete(part);
	}
	
	
	public void deleteById (Long id) {
		partRepository.deleteById(id);
	}
	
}
