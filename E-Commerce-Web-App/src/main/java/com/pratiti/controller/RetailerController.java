package com.pratiti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pratiti.entity.Product;
import com.pratiti.entity.Retailer;
import com.pratiti.exceptions.RetailerServiceException;
import com.pratiti.model.RetailerData;
import com.pratiti.service.RetailerService;

@RestController
@CrossOrigin
public class RetailerController {

	@Autowired
	private RetailerService retailerService;
	
	@GetMapping("/info")
	public Retailer info(@RequestParam("id") int id) {
			Retailer retailer = retailerService.allinfo(id);
			return retailer;
	}
	
	@PostMapping("/register")
	public String register( Retailer retailer) {
				
		try {					
			retailerService.register(retailer);		
			//System.out.println("Retailer registered successfully");
			return "Customer registered successfully";
		}
		catch( RetailerServiceException e){
			return e.getMessage();
//			System.out.println(e.getMessage());
		}
		
		
	}
	
	@PostMapping("/retailer/login")
	public String login(@RequestBody RetailerData retailerData) {
		
		try {
			Retailer retailer = retailerService.login(retailerData.getEmail(), retailerData.getPassword());
			return "Retailer logged in successfully!!";
		}
		catch(Exception e) {
			return(e.getMessage());
		}
	}
	
	@PostMapping("/add-product")
	public String addProduct(@RequestBody Product product) {
		try {
			int id = retailerService.addProduct(product);
			return "Product added successfully!! with id " + id;
		}
		catch(RetailerServiceException e) {
			return (e.getMessage());
		}
	}
	
	@PostMapping("/show-all-products")
	public List<Product> showAllProducts(){
		List<Product> productli = retailerService.showAllProducts();
		return productli;
	}
	
}
