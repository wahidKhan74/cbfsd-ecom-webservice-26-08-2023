package com.simplilearn.ecomorg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplilearn.ecomorg.entity.WhishList;
import com.simplilearn.ecomorg.repository.WhishListRepository;

@Service
public class WhishListService {

	@Autowired
	WhishListRepository whishListRepository;
	
	// Get all whishlists
	public List<WhishList> getWhishLists() {
		return whishListRepository.findAll();
	}
	
	// Get one whishlist by whishlistId
	public WhishList getWhishList(int whishlistId) {
		return whishListRepository.findById(whishlistId).get();
	}
	
	// Add whishlist
	public WhishList addWhishList(WhishList whishlist) {
		return whishListRepository.save(whishlist);
	}
	
	// Update whishlist
	public WhishList updateWhishList(WhishList whishlist) {
		if(whishListRepository.existsById(whishlist.getWishlistId()))
			return whishListRepository.save(whishlist);
		else 
			return null;
	}
	
	// Delete whishlist
	public void deleteWhishList(int whishlistId) {
		whishListRepository.deleteById(whishlistId);
	}
}
