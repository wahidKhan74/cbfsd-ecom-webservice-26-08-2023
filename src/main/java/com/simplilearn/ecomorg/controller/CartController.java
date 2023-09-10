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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.simplilearn.ecomorg.dto.ResponseDto;
import com.simplilearn.ecomorg.entity.Cart;
import com.simplilearn.ecomorg.service.CartService;

// CRUD operation for cart
@RestController
public class CartController {

	@Autowired 
	CartService cartService;
	
	/**
	 * Get all cart list
	 * @return
	 */
	@GetMapping("/carts")
	public List<Cart> getCarts(@RequestParam(value="userId", required = false, defaultValue ="0") int userId){
		if(userId>0) {
			return cartService.getCartByUserId(userId);
		}
		return cartService.getCarts();
	}
	
	/**
	 * Get one cart details
	 * @param cartId
	 * @return
	 */
	@GetMapping("/carts/{cartId}")
	public ResponseDto getCart(@PathVariable int cartId){
		Optional<Cart> cart = cartService.getCart(cartId);
		return new ResponseDto("Cart details is found sucessfully with cartId : "+cartId, new Date(),HttpStatus.OK.name(),cart);
	}
	
	/**
	 * Add new cart details
	 * @param cart
	 * @return
	 **/
	@PostMapping("/carts")
	public ResponseDto addCart(@RequestBody Cart cart){
		Cart cartCreated = cartService.addCart(cart);
		return new ResponseDto("Cart details is created sucessfully.", new Date(),HttpStatus.OK.name(),cartCreated);
	}
	
	/**
	 * Update cart details
	 */
	@PutMapping("/carts")
	public ResponseDto updateCart(@RequestBody Cart cart){
		Cart cartUpdated = cartService.updateCart(cart);
		return new ResponseDto("Cart details is updated sucessfully.", new Date(),HttpStatus.OK.name(),cartUpdated);
	}
	
	/**
	 * Delete cart detail by id.
	 * @param cartId
	 * @return
	 */
	@DeleteMapping("/carts/{cartId}")
	public ResponseDto updateCart(@PathVariable int cartId){
		cartService.deleteCart(cartId);
		return new ResponseDto("Cart details is deleted sucessfully with cartId : "+cartId, new Date(),HttpStatus.OK.name(),null);
	}
}
