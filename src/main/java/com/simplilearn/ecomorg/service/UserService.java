package com.simplilearn.ecomorg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplilearn.ecomorg.entity.User;
import com.simplilearn.ecomorg.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;
	
	// Get all Users
	public List<User> getUsers() {
		return userRepository.findAll();
	}
	
	// Get one User by UserId
	public User getUser(int UserId) {
		return userRepository.findById(UserId).get();
	}
	
	// Add User
	public User addUser(User User) {
		return userRepository.save(User);
	}
	
	// Update User
	public User updateUser(User User) {
		if(userRepository.existsById(User.getUserId()))
			return userRepository.save(User);
		else 
			return null;
	}
	
	// Delete User
	public void deleteUser(int UserId) {
		userRepository.deleteById(UserId);
	}
}
