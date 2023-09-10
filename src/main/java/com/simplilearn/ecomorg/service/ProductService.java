package com.simplilearn.ecomorg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.simplilearn.ecomorg.entity.Product;
import com.simplilearn.ecomorg.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	ProductRepository productRepository;
	
	// Get all products
	public Page<Product> getProducts(int page, int size, String sort, String sortOrder) {
		Sort.Direction direction = sortOrder.equalsIgnoreCase("ASC") ? Sort.Direction.ASC : Sort.Direction.DESC;
		Sort sortBy = Sort.by(direction,sort);
		Pageable pageable = PageRequest.of(page, size, sortBy);
		return productRepository.findAll(pageable);
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
