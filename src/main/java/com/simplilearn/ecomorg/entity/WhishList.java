package com.simplilearn.ecomorg.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "whishlist_details")
@SequenceGenerator(name="whishlist_seq", sequenceName = "whishlist_seq", initialValue =1, allocationSize = 1 )
public class WhishList {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "whishlist_seq")
	@Column(name="wishlist_id")
	private int wishlistId;
	
	@Column(name="product_id")
	private int productId;
	
	@Column(name="user_id")
	private int userId;
	
	@Transient
	private Product products;
}
