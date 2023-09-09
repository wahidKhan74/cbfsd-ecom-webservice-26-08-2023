package com.simplilearn.ecomorg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.simplilearn.ecomorg.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer>{

}
