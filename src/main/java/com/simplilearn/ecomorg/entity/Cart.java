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
@Table(name = "cart_details")
@SequenceGenerator(name="cart_seq", sequenceName = "cart_seq", initialValue =1, allocationSize = 1 )
public class Cart {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cart_seq")
	@Column(name="cart_id")
	private int cartId;
	
	@Column(name="product_id")
	private int productId;
	
	@Column(name="user_id")
	private int userId;
	
	@Column(name="quantity")
	private int quantity;
	
	@Transient
	private Product product;
}
