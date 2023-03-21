package com.pratiti.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pratiti.entity.Product;
import com.pratiti.entity.Retailer;
import com.pratiti.exceptions.RetailerServiceException;
import com.pratiti.repository.ProductRepository;
import com.pratiti.repository.RetailerRepository;

@Service
public class RetailerService {

	@Autowired
	private RetailerRepository retailerRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	public void register(Retailer retailer) {
		if(!retailerRepository.existsByEmail(retailer.getEmail())) {
			retailerRepository.save(retailer);
		}
		else {
			throw new RetailerServiceException("Retailer already EXISTS!!");
		}
	}
	
	public Retailer login(String email, String password) {
		Optional<Retailer> retailer = retailerRepository.findByEmail(email);
		
		if (retailer.isPresent()) {
			Retailer retailerData = retailer.get();
			if (retailerData.getPassword().equals(password)) {
					return retailerData;
			}else {
				throw new RetailerServiceException("Wrong Password");   //generally we give like invalid email or password
			}
		} else {
			throw new RetailerServiceException("Retailer doesn't exist");
		}
	}
	
	public Retailer allinfo(int id){
		Optional<Retailer> retailer = retailerRepository.findById(id);
		Retailer retailerData = retailer.get();
		return retailerData;
	}
	 
	
	
	
	public int addProduct(Product product) {
		Optional<Product> product1 = productRepository.findByNameAndRetailer(product.getName(),product.getRetailer().getId());
		
		if(!product1.isPresent()) {
			productRepository.save(product);
			return (product.getId());
		}
		else {
			throw new RetailerServiceException("Product already exists");
		}
		
	}
	
	public int removeProduct(int id) {
		Optional<Product> product = productRepository.findById(id);
		
		if(product.isPresent()) {
			productRepository.deleteById(id);
			return id;
		}
		else {
			throw new RetailerServiceException("Product doesn't exists");
		}
		
	}
	
	public List<Product> showAllProducts(String email, String password){
		if(retailerRepository.existsByEmail(email)) {
			List<Product> product = productRepository.findAll(email,password);
			return product;
		}
		else {
			throw new RetailerServiceException("Retailer Doesn't EXISTS!!");
		}
		
	}
}
	
