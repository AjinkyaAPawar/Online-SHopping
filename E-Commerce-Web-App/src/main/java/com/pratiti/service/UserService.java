package com.pratiti.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pratiti.entity.Category;
import com.pratiti.entity.Product;
import com.pratiti.exceptions.CustomerServiceException;
import com.pratiti.repository.ProductRepository;

@Service
public class UserService {

	@Autowired
	private ProductRepository productRepository;


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
	
	public Product searchProductById(int id) {
			return productRepository.findById(id).get();
	}
	
	
	// Category
	public List<Product> showProducts(Category category){
		 List<Product> productList = productRepository.findByCategory(category.getId());
		 return productList;
	}
	
	public Product getProductDescription(int productId) {
		 return productRepository.findById(productId).get();
	}

}
