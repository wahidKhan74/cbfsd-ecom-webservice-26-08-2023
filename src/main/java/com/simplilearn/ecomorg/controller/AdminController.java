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

import com.simplilearn.ecomorg.entity.Admin;
import com.simplilearn.ecomorg.service.AdminService;

// CRUD operation for admin
@RestController
public class AdminController {

	@Autowired 
	AdminService adminService;
	
	
	@GetMapping("/admins")
	public List<Admin> getAdmins(){
		return adminService.getAdmins();
	}
	
	@GetMapping("/admins/{adminId}")
	public Admin getAdmin(@PathVariable int adminId){
		return adminService.getAdmin(adminId);
	}
	
	@PostMapping("/admins")
	public Admin addAdmin(@RequestBody Admin admin){
		return adminService.addAdmin(admin);
	}
	
	@PutMapping("/admins")
	public Admin updateAdmin(@RequestBody Admin admin){
		return adminService.updateAdmin(admin);
	}
	
	@DeleteMapping("/admins/{adminId}")
	public String updateAdmin(@PathVariable int adminId){
		adminService.deleteAdmin(adminId);
		return "Admin is deleted sucessfully with adminId : "+adminId;
	}
}
