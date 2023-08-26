package com.simplilearn.ecomorg.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.simplilearn.ecomorg.model.Product;

// CRUD operation for product
@RestController
public class ProductController {

	List<Product> products = new ArrayList<Product>();
	
	@GetMapping("/products")
	public List<Product> getProducts(){
		return products;
	}
	
	@PostMapping("/products")
	public List<Product> addProduct(@RequestBody Product product){
		int id = product.
		return products;
	}
	
}
