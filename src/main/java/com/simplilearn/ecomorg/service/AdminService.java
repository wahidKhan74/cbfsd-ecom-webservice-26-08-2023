package com.simplilearn.ecomorg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.simplilearn.ecomorg.entity.Admin;
import com.simplilearn.ecomorg.repository.AdminRepository;

@Service
public class AdminService {

	@Autowired
	AdminRepository adminRepository;
	
	BCryptPasswordEncoder passwordEncoder ;
	
	// Get all Admins
	public List<Admin> getAdmins() {
		return adminRepository.findAll();
	}
	
	// Get one Admin by AdminId
	public Admin getAdmin(int AdminId) {
		return adminRepository.findById(AdminId).get();
	}
	
	// Add Admin
	public Admin addAdmin(Admin admin) {
		passwordEncoder = new BCryptPasswordEncoder();
		admin.setPassword(passwordEncoder.encode(admin.getPassword()));
		return adminRepository.save(admin);
	}
	
	// Update Admin
	public Admin updateAdmin(Admin admin) {
		passwordEncoder = new BCryptPasswordEncoder();
		admin.setPassword(passwordEncoder.encode(admin.getPassword()));
		if(adminRepository.existsById(admin.getAdminId()))
			return adminRepository.save(admin);
		else 
			return null;
	}
	
	// Delete Admin
	public void deleteAdmin(int AdminId) {
		adminRepository.deleteById(AdminId);
	}
}
