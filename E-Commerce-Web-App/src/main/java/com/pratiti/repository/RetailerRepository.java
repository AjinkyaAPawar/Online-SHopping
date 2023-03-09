package com.pratiti.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.pratiti.entity.Retailer;

public interface RetailerRepository extends JpaRepository<Retailer, Integer>{
	
	public boolean existsByEmail(String email);
	public Optional<Retailer> findByEmail(String email);
}
