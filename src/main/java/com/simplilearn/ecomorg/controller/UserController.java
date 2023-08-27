package com.simplilearn.ecomorg.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.simplilearn.ecomorg.entity.User;
import com.simplilearn.ecomorg.service.UserService;

// CRUD operation for user
@RestController
public class UserController {

	@Autowired 
	UserService userService;
	
	@GetMapping("/users")
	public List<User> getUsers(){
		return userService.getUsers();
	}
	
	@GetMapping("/users/{userId}")
	public User getUser(@PathVariable int userId){
		return userService.getUser(userId);
	}
	
	@PostMapping("/users")
	public User addUser(@RequestBody User user){
		return userService.addUser(user);
	}
	
	@PutMapping("/users")
	public User updateUser(@RequestBody User user){
		return userService.updateUser(user);
	}
	
	@DeleteMapping("/users/{userId}")
	public String updateUser(@PathVariable int userId){
		userService.deleteUser(userId);
		return "User is deleted sucessfully with userId : "+userId;
	}
}
