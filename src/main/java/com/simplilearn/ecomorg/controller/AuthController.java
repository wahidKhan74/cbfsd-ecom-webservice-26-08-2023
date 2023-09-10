package com.simplilearn.ecomorg.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.simplilearn.ecomorg.dto.LoginRequestDto;
import com.simplilearn.ecomorg.dto.ResponseDto;
import com.simplilearn.ecomorg.entity.Admin;
import com.simplilearn.ecomorg.entity.User;
import com.simplilearn.ecomorg.service.AdminService;
import com.simplilearn.ecomorg.service.UserService;

/**
 * Admin authentication
 * @author khanw
 *
 */
@RestController
public class AuthController {

	@Autowired 
	AdminService adminService;
	
	@Autowired 
	UserService userService;
	
	@PostMapping("/admins/login")
	public ResponseDto adminLogin(@RequestBody LoginRequestDto login){
		Admin admin = adminService.validateLogin(login);
		return new ResponseDto("Admin user loggedIn sucessfully.", new Date(),HttpStatus.OK.name(),admin);
	}
	
	@PostMapping("/users/login")
	public ResponseDto useLogin(@RequestBody LoginRequestDto login){
		User user = userService.validateLogin(login);
		return new ResponseDto("User loggedIn sucessfully.", new Date(),HttpStatus.OK.name(),user);
	}
	
}
