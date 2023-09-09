package com.simplilearn.ecomorg.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.simplilearn.ecomorg.dto.ResponseDto;
import com.simplilearn.ecomorg.entity.Order;
import com.simplilearn.ecomorg.service.OrderService;

// CRUD operation for order
@RestController
public class OrderController {

	@Autowired 
	OrderService orderService;
	
	
	@GetMapping("/orders")
	public List<Order> getOrders(){
		return orderService.getOrders();
	}
	
	@GetMapping("/orders/{orderId}")
	public ResponseDto getOrder(@PathVariable int orderId){
		Optional<Order> order = orderService.getOrder(orderId);
		return new ResponseDto("Order user is found sucessfully with orderId : "+orderId, new Date(),HttpStatus.OK.name(),order);
	}
	
	@PostMapping("/orders")
	public ResponseDto addOrder(@RequestBody Order order){
		Order orderCreated = orderService.addOrder(order);
		return new ResponseDto("Order user is created sucessfully.", new Date(),HttpStatus.OK.name(),orderCreated);
	}
	
	@PutMapping("/orders")
	public ResponseDto updateOrder(@RequestBody Order order){
		Order orderUpdated = orderService.updateOrder(order);
		return new ResponseDto("Order user is updated sucessfully.", new Date(),HttpStatus.OK.name(),orderUpdated);
	}
	
	@DeleteMapping("/orders/{orderId}")
	public ResponseDto updateOrder(@PathVariable int orderId){
		orderService.deleteOrder(orderId);
		return new ResponseDto("Order user is deleted sucessfully with orderId : "+orderId, new Date(),HttpStatus.OK.name(),null);
	}
}
