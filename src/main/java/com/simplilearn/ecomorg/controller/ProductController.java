package com.simplilearn.ecomorg.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	@GetMapping("/products/{productId}")
	public Product getProduct(@PathVariable int productId){
		
		for (Product product : products) {
			if(product.getProductId() == productId)
				return product;
		}
		return null;
	}
	
	@PostMapping("/products")
	public List<Product> addProduct(@RequestBody Product product){
		products.add(product);
		return products;
	}
	
	@PutMapping("/products")
	public List<Product> updateProduct(@RequestBody Product product){
		if (product != null) { 
			for (int index = 0; index < products.size(); index++) { 
				if (products.get(index).getProductId() == product.getProductId() ) {
					// replace /update on products list object
					products.set(index, product);
					return products;
				}
			}
		}
		return null;
	}
	
	@DeleteMapping("/products/{productId}")
	public List<Product> updateProduct(@PathVariable int productId){
		if (productId>0) { 
			for (int index = 0; index < products.size(); index++) { 
				if (products.get(index).getProductId() == productId) {
					// remove match  products list object
					products.remove(index);
					return products;
				}
			}
		}
		return null;
	}
}
