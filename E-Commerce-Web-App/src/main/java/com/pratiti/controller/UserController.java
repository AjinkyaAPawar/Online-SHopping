package com.pratiti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pratiti.entity.Category;
import com.pratiti.entity.Order;
import com.pratiti.entity.Product;
import com.pratiti.entity.Retailer;
import com.pratiti.entity.User;
import com.pratiti.model.RetailerData;
import com.pratiti.service.UserService;

@RestController
@CrossOrigin
public class UserController {

	@Autowired
	private UserService userService;
	
	// User Login
//	@PostMapping("/user/login")
//	public User login(@RequestParam String email,@RequestParam String password) {
//		
//		try {
//			User user = userService.login(email, password);
//			return user;
//		}
//		catch(Exception e) {
//			return null;
//		}
//	}
	
	
	// Searching product
	@GetMapping("/search")
	public List<Product> searchProduct(@RequestParam("name") String name) {
			return userService.searchProduct(name);
			
	}
	
	
	//Showing Product as per Category
	@PostMapping("/show-products")
	public List<Product> showProducts(@RequestBody Category category){
		List<Product> product = userService.showProducts(category);
		return product;
	}
	
	
	// Getting Product Discription
	@GetMapping("/get-product-description")
	public Product getProductDescription(@RequestParam int productId) {
		return userService.getProductDescription(productId);
	}

	
	@PostMapping("/add/order")
	public void addOrder(@RequestBody Order order) {
		userService.addUserOrder(order);
	}
	
	@PostMapping("/user/register")
	public User login(@RequestBody User user) {
		
		try {
			User user1 = userService.register(user);
			return user1;
		}
		catch(Exception e) {
			return null;
		}
	}}
