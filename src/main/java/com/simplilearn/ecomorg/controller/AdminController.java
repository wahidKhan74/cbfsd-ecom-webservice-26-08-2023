package com.simplilearn.ecomorg.controller;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
import com.simplilearn.ecomorg.entity.Admin;
import com.simplilearn.ecomorg.service.AdminService;

// CRUD operation for admin
@RestController
public class AdminController {

	@Autowired 
	AdminService adminService;
	
	
	@GetMapping("/admins")
	public Page<Admin> getAdmins(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size, 
			@RequestParam(defaultValue = "adminId") String sort, @RequestParam(defaultValue = "ASC") String sortOrder){
		return adminService.getAdmins(page,size, sort, sortOrder);
	}
	
	@GetMapping("/admins/{adminId}")
	public ResponseDto getAdmin(@PathVariable int adminId){
		Optional<Admin> admin = adminService.getAdmin(adminId);
		return new ResponseDto("Admin user is found sucessfully with adminId : "+adminId, new Date(),HttpStatus.OK.name(),admin);
	}
	
	@PostMapping("/admins")
	public ResponseDto addAdmin(@RequestBody Admin admin){
		Admin adminCreated = adminService.addAdmin(admin);
		return new ResponseDto("Admin user is created sucessfully.", new Date(),HttpStatus.OK.name(),adminCreated);
	}
	
	@PutMapping("/admins")
	public ResponseDto updateAdmin(@RequestBody Admin admin){
		Admin adminUpdated = adminService.updateAdmin(admin);
		return new ResponseDto("Admin user is updated sucessfully.", new Date(),HttpStatus.OK.name(),adminUpdated);
	}
	
	@DeleteMapping("/admins/{adminId}")
	public ResponseDto updateAdmin(@PathVariable int adminId){
		adminService.deleteAdmin(adminId);
		return new ResponseDto("Admin user is deleted sucessfully with adminId : "+adminId, new Date(),HttpStatus.OK.name(),null);
	}
}
