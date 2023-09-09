package com.simplilearn.ecomorg.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Product category model
 * @author khanw
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="categories")
@SequenceGenerator(name="categories_seq", sequenceName = "categories_seq", initialValue =1, allocationSize = 1 )
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "categories_seq")
	@Column(name="category_id")
	private int categoryId;
	
	@Column(name="category_name")
	private String categoryName;
	
	@Column(name="category_description")
	private String categoryDescription;
	
	@Column(name="category_image_url")
	private String categoryImageUrl;
	
	@Column(name="active")
	private int active;
	
	@Column(name="added_on")
	private Date addedOn = new Date();
}
