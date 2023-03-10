package com.pratiti.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pratiti.entity.Category;
import com.pratiti.entity.Order;
import com.pratiti.entity.Product;
import com.pratiti.entity.User;
import com.pratiti.exceptions.CustomerServiceException;
import com.pratiti.exceptions.RetailerServiceException;
import com.pratiti.repository.OrderRepository;
import com.pratiti.repository.ProductRepository;
import com.pratiti.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private ProductRepository productRepository;

	@Autowired 
	private UserRepository userRepository;
	
	@Autowired 
	private OrderRepository orderRepository; 

	
	// Service For login
	public User login(String email, String password) {
		Optional<User> user = userRepository.findByEmail(email);
		
		if (user.isPresent()) {
			User userData = user.get();
			if (userData.getPassword().equals(password)) {
					return userData;
			}else {
				throw new RetailerServiceException("Wrong Password");   //generally we give like invalid email or password
			}
		} else {
			throw new RetailerServiceException("Retailer doesn't exist");
		}
	}
	

	//Service For Searching Product by their name
	public List<Product> searchProduct(String name) {
		List<Product>ProductData = new ArrayList<>();
		List<Product> product = productRepository.findByName(name);
		if (!product.isEmpty()) {
            
			for(Product productData : product) {
			  ProductData.add(productData);
			}
			return ProductData;
		} else {
			throw new CustomerServiceException("Invalid credentials");
		}
	}
	
	
	//Service for Searching product By their Id
	public Product searchProductById(int id) {
			return productRepository.findById(id).get();
	}
	
	
	// Category
	public List<Product> showProducts(int id){
		 List<Product> productList = productRepository.findByCategory(id);
		 return productList;
	}
	
	// For Description of product
	public Product getProductDescription(int productId) {
		 return productRepository.findById(productId).get();
	}


	//
	public void addUserOrder(Order order) {
         orderRepository.save(order);
	}


	public User register(User user) {

		if(!userRepository.existsByEmail(user.getEmail())) {
			userRepository.save(user);
		}
		else {
			throw new RetailerServiceException("Retailer already EXISTS!!");
		}
		
		return null;
	}


	public Product showProductById(int id) {

		Optional<Product> product = productRepository.findById(id);
		
		return product.get();
	}
	
	
	

}
