package com.example.relationshipsrestapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.relationshipsrestapi.model.Part;

@Repository
public interface PartRepository extends JpaRepository<Part, Long>{

}
