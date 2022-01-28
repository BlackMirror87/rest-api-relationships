package com.example.relationshipsrestapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.relationshipsrestapi.model.Adress;

@Repository
public interface AdressRepository extends JpaRepository<Adress, Long>{

}
