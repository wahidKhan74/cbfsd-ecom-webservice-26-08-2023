package com.simplilearn.ecomorg.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplilearn.ecomorg.entity.WhishList;
import com.simplilearn.ecomorg.exception.BadRequestException;
import com.simplilearn.ecomorg.exception.NotFoundException;
import com.simplilearn.ecomorg.repository.WhishListRepository;
import com.simplilearn.ecomorg.util.StringUtil;

@Service
public class WhishListService {

	@Autowired
	WhishListRepository whishListRepository;
	
	// Get all whishlists
	public List<WhishList> getWhishLists() {
		return whishListRepository.findAll();
	}
	
	// Get one whishlist by whishlistId
	public Optional<WhishList> getWhishList(int whishlistId) {
		Optional<WhishList> whishlist =  whishListRepository.findById(whishlistId);
		if(whishlist.isPresent() && StringUtil.isNotNull(whishlist))
			return whishlist;
		else 
			throw new NotFoundException("The whishlist details does not exist with provided whishlistId.");
	}
	
	// Add whishlist
	public WhishList addWhishList(WhishList whishlist) {
		return whishListRepository.save(whishlist);
	}
	
	// Update whishlist
	public WhishList updateWhishList(WhishList whishlist) {
		if(whishlist.getWishlistId() <=0 )
			throw new BadRequestException("whishlistId id cannot be null or empty.");
		if(whishListRepository.existsById(whishlist.getWishlistId()))
			return whishListRepository.save(whishlist);
		else 
			throw new NotFoundException("The whishlist details does not exist with provided whishlistId.");
	}
	
	// Delete whishlist
	public void deleteWhishList(int whishlistId) {
		if(whishlistId <=0 )
			throw new BadRequestException("whishlistId id cannot be null or empty.");
		if(whishListRepository.existsById(whishlistId))
			whishListRepository.deleteById(whishlistId);
		else 
			throw new NotFoundException("The whishlist details does not exist with provided whishlistId.");
	}
}
