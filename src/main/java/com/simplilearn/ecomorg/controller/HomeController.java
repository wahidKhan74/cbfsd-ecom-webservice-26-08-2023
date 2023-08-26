package com.simplilearn.ecomorg.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	@ResponseBody
	public String indexMapping() {
		return "Hello, Server is up and running !";
	}
	
	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	@ResponseBody
	public String helloMapping(@RequestParam(required = false) String username) {
		if(username!=null)
			return "Hello, "+username;
		return "Hello, user";
	}
	
	@RequestMapping(value = "/age", method = RequestMethod.GET)
	@ResponseBody
	public String ageCalc(@RequestParam(required = false) int yearOfBith) {
		int currentYear = 2023;
		if(yearOfBith>0 && currentYear>=yearOfBith)
			return "Your Age is :-  "+ (currentYear-yearOfBith);
		return "Invalid Year of Birth";
	}
	
	@RequestMapping(value = "/users/{userId}", method = RequestMethod.GET)
	@ResponseBody
	public String getUser(@PathVariable int userId) {
		return "User exist with the given userId : "+userId;
	}
	
	@RequestMapping(value = "/users/{userId}/reviews/{reviewId}", method = RequestMethod.GET)
	@ResponseBody
	public String getUserReview(@PathVariable int userId, @PathVariable int reviewId) {
		return "User exist with the given userId : "+userId +  " &  review alos exist with reviewId : "+reviewId;
	}
	
	@RequestMapping(value = "/data", method = RequestMethod.POST)
	@ResponseBody()
	public Object submitData(@RequestBody Object data) {
		return data;
	}
	
	@RequestMapping(value = "/token", method = RequestMethod.POST)
	@ResponseBody
	public String authToken(@RequestHeader("Authorization")String authToken) {
		return authToken ;
	}
}
