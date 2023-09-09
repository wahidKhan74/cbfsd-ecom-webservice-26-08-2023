package com.simplilearn.ecomorg.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplilearn.ecomorg.entity.Category;
import com.simplilearn.ecomorg.exception.NotFoundException;
import com.simplilearn.ecomorg.repository.CategoryRepository;
import com.simplilearn.ecomorg.util.StringUtil;

@Service
public class CategoryService {

	@Autowired
	CategoryRepository categoryRepository;
	
	// Get all categorys
	public List<Category> getCategories() {
		return categoryRepository.findAll();
	}
	
	// Get one category by categoryId
	public Optional<Category> getCategory(int categoryId) {
		Optional<Category> category = categoryRepository.findById(categoryId);
		if(StringUtil.isNotNull(category) && category.isPresent())
			return category;
		else
			throw new NotFoundException("The category does not exist with provided categoryId.");
	}
	
	// Add category
	public Category addCategory(Category category) {
		return categoryRepository.save(category);
	}
	
	// Update category
	public Category updateCategory(Category category) {
		if(categoryRepository.existsById(category.getCategoryId()))
			return categoryRepository.save(category);
		else 
			throw new NotFoundException("The category does not exist with provided categoryId.");
	}
	
	// Delete category
	public void deleteCategory(int categoryId) {
		if(categoryRepository.existsById(categoryId))
			categoryRepository.deleteById(categoryId);
		else 
			throw new NotFoundException("The category does not exist with provided categoryId.");
	}
}
