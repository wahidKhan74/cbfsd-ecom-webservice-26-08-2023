package com.simplilearn.ecomorg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.simplilearn.ecomorg.entity.Cart;
import com.simplilearn.ecomorg.entity.WhishList;

@Repository
public interface WhishListRepository extends JpaRepository<WhishList, Integer>{

}
