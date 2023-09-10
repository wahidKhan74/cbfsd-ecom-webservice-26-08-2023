package com.simplilearn.ecomorg.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.simplilearn.ecomorg.entity.Product;
import com.simplilearn.ecomorg.service.ProductService;

// CRUD operation for product
@RestController
public class ProductController {

	@Autowired 
	ProductService productService;
	
	@GetMapping("/products")
	public Page<Product> getProducts(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size,
			@RequestParam(defaultValue = "productId") String sort, @RequestParam(defaultValue = "ASC") String sortOrder){
		return productService.getProducts(page,size,sort, sortOrder);
	}
	
	@GetMapping("/products/{productId}")
	public Product getProduct(@PathVariable int productId){
		return productService.getProduct(productId);
	}
	
	@PostMapping("/products")
	public Product addProduct(@RequestBody Product product){
		return productService.addProduct(product);
	}
	
	@PutMapping("/products")
	public Product updateProduct(@RequestBody Product product){
		return productService.updateProduct(product);
	}
	
	@DeleteMapping("/products/{productId}")
	public String updateProduct(@PathVariable int productId){
		productService.deleteProduct(productId);
		return "PRoduct is deleted sucessfully with productId : "+productId;
	}
}
