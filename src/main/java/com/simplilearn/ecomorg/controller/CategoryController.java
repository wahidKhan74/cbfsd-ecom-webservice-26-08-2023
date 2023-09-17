package com.simplilearn.ecomorg.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.simplilearn.ecomorg.dto.ResponseDto;
import com.simplilearn.ecomorg.entity.Category;
import com.simplilearn.ecomorg.service.CategoryService;

/**
 * CRUD operation for category
 * @author khanw
 */
@RestController
public class CategoryController {

	@Autowired 
	CategoryService categoryService;
	
	/**
	 * Get list of all categories 
	 * @return
	 */
	@GetMapping("/categories")
	public Page<Category> getCategorys(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size, 
			@RequestParam(defaultValue = "categoryId") String sort, @RequestParam(defaultValue = "ASC") String sortOrder){
		return categoryService.getCategories(page,size, sort, sortOrder);
	}
	
	/**
	 * Get a category by id if exist.
	 * @param categoryId
	 * @return
	 */
	@GetMapping("/categories/{categoryId}")
	public Optional<Category> getCategory(@PathVariable int categoryId){
		return categoryService.getCategory(categoryId);

	}
	
	/**
	 * Create a new category.
	 * @param category
	 * @return
	 */
	@PostMapping("/categories")
	public Category addCategory(@RequestBody Category category){
		return categoryService.addCategory(category);
	}
	
	/**
	 * Update a categories by id if exist.
	 * @param category
	 * @return
	 */
	@PutMapping("/categories")
	public Category updateCategory(@RequestBody Category category){
		return categoryService.updateCategory(category);
	}
	
	/**
	 * Delete a categories by id if exist.
	 * @param categoryId
	 * @return
	 */
	@DeleteMapping("/categories/{categoryId}")
	public ResponseDto updateCategory(@PathVariable int categoryId){
		categoryService.deleteCategory(categoryId);
		return new ResponseDto("Category is deleted sucessfully with categoryId : "+categoryId, new Date(),HttpStatus.OK.name(),null);
	}
}
