package com.simplilearn.ecomorg.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Date;
import java.util.LinkedHashMap;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import com.simplilearn.ecomorg.dto.ResponseDto;
import com.simplilearn.ecomorg.entity.Admin;
import com.simplilearn.ecomorg.exception.NotFoundException;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@DisplayName("Admin Controller Test")
public class AdminControllerTest {
	
	@LocalServerPort
	private int randomPort;
	
	@Autowired
	private TestRestTemplate restTempClient;
	
	
	@Test
	@Disabled
	@DisplayName("Should Create a admin user")
	public void testAddAdminUsers() {
		String URL ="http://localhost:"+randomPort+"/ecomorg-webservice/api/admins";
		//create admin object
		Admin adminObj = new Admin();
		adminObj.setEmail("admin31@simplilearn.com");
		adminObj.setPassword("Admin31@123");
		adminObj.setAddedOn( new Date());
		adminObj.setFullName("Admin31");
		adminObj.setLoginType(2);
		// HttpEntity Mapping
		HttpEntity<Admin> requestOb = new HttpEntity<Admin>(adminObj);
		
		ResponseEntity<ResponseDto> response = restTempClient.exchange(URL,HttpMethod.POST, requestOb, new ParameterizedTypeReference<ResponseDto>() {});
		ResponseDto restResponse = response.getBody();
		
		assertEquals(200, response.getStatusCodeValue());
		assertEquals("Admin user is created sucessfully.", restResponse.getMessage());
		assertNotNull(restResponse.getData());		
		assertEquals("admin31@simplilearn.com", ((LinkedHashMap<String, String>) restResponse.getData()).get("email"));
	}
	
	@Test
	@DisplayName("Should Check If Admin user already exit")
	public void testAddAdminUsersExits() {
		String URL ="http://localhost:"+randomPort+"/ecomorg-webservice/api/admins";
		//create admin object
		Admin adminObj = new Admin();
		adminObj.setEmail("admin31@simplilearn.com");
		adminObj.setPassword("Admin31@123");
		adminObj.setAddedOn( new Date());
		adminObj.setFullName("Admin31");
		adminObj.setLoginType(2);
		// HttpEntity Mapping
		HttpEntity<Admin> requestOb = new HttpEntity<Admin>(adminObj);
		
		ResponseEntity<ResponseDto> response = restTempClient.exchange(URL,HttpMethod.POST, requestOb, new ParameterizedTypeReference<ResponseDto>() {});
		assertEquals(400, response.getStatusCodeValue());
		
	}
	
	@Test
	@DisplayName("Should return a admin user (one admin user)")
	public void testGetOneAdminUsers() {
		String URL ="http://localhost:"+randomPort+"/ecomorg-webservice/api/admins/21";
		ResponseEntity<ResponseDto> response = restTempClient.exchange(URL,HttpMethod.GET, null, new ParameterizedTypeReference<ResponseDto>() {});
		ResponseDto restResponse = response.getBody();
		
		assertEquals(200, response.getStatusCodeValue());
		assertEquals("Admin user is found sucessfully with adminId : 21", restResponse.getMessage());
		assertNotNull(restResponse.getData());		
		assertEquals("admin21@simplilearn.com", ((LinkedHashMap<String, String>) restResponse.getData()).get("email"));
	}
	
	@Test
	@DisplayName("Should return exception when a admin user does not exit.")
	public void testGetOneAdminUsersNotExist() {
		String URL ="http://localhost:"+randomPort+"/ecomorg-webservice/api/admins/2";
		ResponseEntity<ResponseDto> response = restTempClient.exchange(URL,HttpMethod.GET, null, new ParameterizedTypeReference<ResponseDto>() {});
		assertEquals(404, response.getStatusCodeValue());
	}

	
	@Test
	@DisplayName("Should return a list of admin users")
	public void testGetAllAdminUsers() {
		String URL ="http://localhost:"+randomPort+"/ecomorg-webservice/api/admins?page=0&size=5&sort=adminId&sortOrder=DESC";
		ResponseEntity<Object> response = restTempClient.exchange(URL,HttpMethod.GET, null, new ParameterizedTypeReference<Object>() {});
		assertEquals(200, response.getStatusCodeValue());
		assertNotNull(response.getBody());
	}

	
}
