package com.simplilearn.ecomorg.model;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Product {

	// data properties
	private int productId;
	private String productTitle;
	private String productDescription;
	private String productCode;
	private List<String> images;
	private int thumbnailImage;
	private int price;
	private Date addedOn;
	private int rating;
}
