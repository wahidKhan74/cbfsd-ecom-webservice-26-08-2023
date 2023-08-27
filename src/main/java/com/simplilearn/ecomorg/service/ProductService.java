package com.simplilearn.ecomorg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplilearn.ecomorg.entity.Product;
import com.simplilearn.ecomorg.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	ProductRepository productRepository;
	
	// Get all products
	public List<Product> getProducts() {
		return productRepository.findAll();
	}
	
	// Get one product by productId
	public Product getProduct(int productId) {
		return productRepository.findById(productId).get();
	}
	
	// Add product
	public Product addProduct(Product product) {
		return productRepository.save(product);
	}
	
	// Update product
	public Product updateProduct(Product product) {
		if(productRepository.existsById(product.getProductId()))
			return productRepository.save(product);
		else 
			return null;
	}
	
	// Delete product
	public void deleteProduct(int productId) {
		productRepository.deleteById(productId);
	}
}
