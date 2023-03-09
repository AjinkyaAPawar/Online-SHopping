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
import com.pratiti.entity.Product;
import com.pratiti.service.UserService;

@RestController
@CrossOrigin
public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/search")
	public List<Product> searchProduct(@RequestParam("name") String name) {
			return userService.searchProduct(name);
			
	}
	
	@PostMapping("/show-products")
	public List<Product> showProducts(@RequestBody Category category){
		List<Product> product = userService.showProducts(category);
		return product;
	}
	
	@GetMapping("/get-product-description")
	public Product getProductDescription(@RequestParam int productId) {
		return userService.getProductDescription(productId);
	}

}
