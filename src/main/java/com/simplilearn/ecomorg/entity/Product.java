package com.simplilearn.ecomorg.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "products")
@SequenceGenerator(name="product_seq", sequenceName = "product_seq", initialValue =1, allocationSize = 1 )
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_seq")
	@Column(name="product_id")
	private int productId;
	
	@Column(name="product_title")
	private String productTitle;
	
	@Column(name="product_description")
	private String productDescription;
	
	@Column(name="product_code")
	private String productCode;
	
	@ElementCollection
	@CollectionTable(name = "product_images", joinColumns =@JoinColumn(name = "product_id"))
	@Column(name="image_url")
	private List<String> imageUrls = new ArrayList<>();
	
	@Column(name="thumbnail_image")
	private int thumbnailImage;
	
	@Column(name="product_price")
	private int price;
	
	@Column(name="addedOn")
	private Date addedOn = new Date();
	
	@Column(name="rating")
	private int rating;
	
	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category productCategory;
}
