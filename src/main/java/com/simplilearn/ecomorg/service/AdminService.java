package com.simplilearn.ecomorg.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.simplilearn.ecomorg.dto.LoginRequestDto;
import com.simplilearn.ecomorg.entity.Admin;
import com.simplilearn.ecomorg.exception.BadRequestException;
import com.simplilearn.ecomorg.exception.NotFoundException;
import com.simplilearn.ecomorg.repository.AdminRepository;
import com.simplilearn.ecomorg.util.StringUtil;

@Service
public class AdminService {

	@Autowired
	AdminRepository adminRepository;
	
	BCryptPasswordEncoder passwordEncoder ;
	
	// Get all Admins
	public Page<Admin> getAdmins(int page, int size, String sort, String sortOrder) {
		Sort.Direction direction = sortOrder.equalsIgnoreCase("ASC") ? Sort.Direction.ASC : Sort.Direction.DESC;
		Sort sortBy = Sort.by(direction,sort);
		Pageable pageable = PageRequest.of(page, size, sortBy);
		return adminRepository.findAll(pageable);
	}
	
	// Get one Admin by AdminId
	public Optional<Admin> getAdmin(int AdminId) {
		Optional<Admin> admin = adminRepository.findById(AdminId);
		if(admin.isPresent() && StringUtil.isNotNull(admin))
			return admin;
		else 
			throw new NotFoundException("The admin user does not exist with provided adminId.");
	}
	
	// Add Admin
	public Admin addAdmin(Admin admin) {
		if(adminRepository.existsByEmail(admin.getEmail()))
			throw new BadRequestException("Admin user with this email address already exists.");
		passwordEncoder = new BCryptPasswordEncoder();
		admin.setPassword(passwordEncoder.encode(admin.getPassword()));
		return adminRepository.save(admin);
	}
	
	// Update Admin
	public Admin updateAdmin(Admin admin) {
		if(admin.getAdminId() <=0 )
			throw new BadRequestException("adminId id cannot be null or empty.");
		passwordEncoder = new BCryptPasswordEncoder();
		admin.setPassword(passwordEncoder.encode(admin.getPassword()));
		if(adminRepository.existsById(admin.getAdminId()))
			return adminRepository.save(admin);
		else 
			throw new NotFoundException("The admin user does not exist with provided adminId.");
	}
	
	// Delete Admin
	public void deleteAdmin(int adminId) {
		if(adminId <=0 )
			throw new BadRequestException("adminId id cannot be null or empty.");
		if(adminRepository.existsById(adminId))
			adminRepository.deleteById(adminId);
		else 
			throw new NotFoundException("The admin user does not exist with provided adminId.");
	}

	public Admin validateLogin(LoginRequestDto loginDto) {
		boolean exist = adminRepository.existsByEmail(loginDto.getEmail()) ;
		if(exist) {
			Admin admin = adminRepository.findByEmail(loginDto.getEmail());
			passwordEncoder = new BCryptPasswordEncoder();
			if(passwordEncoder.matches(loginDto.getPassword(), admin.getPassword())) {
				return admin;
			} else {
				throw new NotFoundException("Invalid password, Password mismatch error.");
			}
		} else {
			throw new NotFoundException("Admin user does not exist.");
		}
	}
}
