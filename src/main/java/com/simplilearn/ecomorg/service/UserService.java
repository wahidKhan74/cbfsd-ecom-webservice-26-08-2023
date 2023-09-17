package com.simplilearn.ecomorg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.simplilearn.ecomorg.dto.LoginRequestDto;
import com.simplilearn.ecomorg.entity.Admin;
import com.simplilearn.ecomorg.entity.User;
import com.simplilearn.ecomorg.exception.BadRequestException;
import com.simplilearn.ecomorg.exception.NotFoundException;
import com.simplilearn.ecomorg.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;
	
	BCryptPasswordEncoder passwordEncoder ;
	
	// Get all Users
	public Page<User> getUsers(int page, int size, String sort, String sortOrder) {
		Sort.Direction direction = sortOrder.equalsIgnoreCase("ASC") ? Sort.Direction.ASC : Sort.Direction.DESC;
		Sort sortBy = Sort.by(direction,sort);
		Pageable pageable = PageRequest.of(page, size, sortBy);
		return userRepository.findAll(pageable);
	}
	
	// Get one User by UserId
	public User getUser(int UserId) {
		return userRepository.findById(UserId).get();
	}
	
	// Add User
	public User addUser(User user) {
		if(userRepository.existsByEmail(user.getEmail()))
			throw new BadRequestException("User with this email address already exists.");
		passwordEncoder = new BCryptPasswordEncoder();
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		return userRepository.save(user);
	}
	
	// Update User
	public User updateUser(User user) {
		if(user.getUserId() <=0 )
			throw new BadRequestException("UserId cannot be null or empty.");
		passwordEncoder = new BCryptPasswordEncoder();
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		if(userRepository.existsById(user.getUserId()))
			return userRepository.save(user);
		else 
			throw new NotFoundException("User does not exist with provided userId.");

	}
	
	// Delete User
	public void deleteUser(int userId) {
		if(userId <=0 )
			throw new BadRequestException("adminId id cannot be null or empty.");
		if(userRepository.existsById(userId))
			userRepository.deleteById(userId);
		else 
			throw new NotFoundException("The admin user does not exist with provided adminId.");
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
