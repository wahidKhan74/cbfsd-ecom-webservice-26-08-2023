package com.simplilearn.ecomorg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplilearn.ecomorg.entity.Cart;
import com.simplilearn.ecomorg.repository.CartRepository;

@Service
public class CartService {

	@Autowired
	CartRepository cartRepository;
	
	// Get all carts
	public List<Cart> getCarts() {
		return cartRepository.findAll();
	}
	
	// Get one cart by cartId
	public Cart getCart(int cartId) {
		return cartRepository.findById(cartId).get();
	}
	
	// Add cart
	public Cart addCart(Cart cart) {
		return cartRepository.save(cart);
	}
	
	// Update cart
	public Cart updateCart(Cart cart) {
		if(cartRepository.existsById(cart.getCartId()))
			return cartRepository.save(cart);
		else 
			return null;
	}
	
	// Delete cart
	public void deleteCart(int cartId) {
		cartRepository.deleteById(cartId);
	}
}
