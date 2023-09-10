package com.simplilearn.ecomorg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.simplilearn.ecomorg.dto.LoginRequestDto;
import com.simplilearn.ecomorg.entity.Admin;
import com.simplilearn.ecomorg.entity.User;
import com.simplilearn.ecomorg.exception.NotFoundException;
import com.simplilearn.ecomorg.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;
	
	BCryptPasswordEncoder passwordEncoder ;
	
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
	
	public User validateLogin(LoginRequestDto loginDto) {
		boolean exist = userRepository.existsByEmail(loginDto.getEmail()) ;
		if(exist) {
			User user = userRepository.findByEmail(loginDto.getEmail());
			passwordEncoder = new BCryptPasswordEncoder();
			if(passwordEncoder.matches(loginDto.getPassword(), user.getPassword())) {
				return user;
			} else {
				throw new NotFoundException("Invalid password, Password mismatch error.");
			}
		} else {
			throw new NotFoundException("User does not exist.");
		}
	}
}
