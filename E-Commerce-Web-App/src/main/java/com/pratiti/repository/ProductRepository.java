package com.pratiti.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.pratiti.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

	@Query("select p from Product p where p.name = ?1 or p.brand = ?1")
	List<Product> findByName(String name);
	
	@Query("select p from Product p where p.name =?1 and p.retailer.id=?2")
	public Optional<Product> findByNameAndRetailer(String name, int retailerId);
	
	@Query("select p from Product p where p.category.id = ?1")
	public List<Product> findByCategory(int category);
	
	@Query("select p from Product p where p.retailer=?1")
	public List<Product> findByRetailerId(int id);
	
	@Query("select p from Product p join p.retailer r where r.email = ?1 and r.password = ?2 ")
	public List<Product> findAll(String email, String password);

}
