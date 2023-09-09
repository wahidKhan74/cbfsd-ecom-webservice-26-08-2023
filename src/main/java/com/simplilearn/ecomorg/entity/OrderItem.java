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
 * Order item model
 * 
 * @author khanw
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "order_items")
@SequenceGenerator(name="order_item_seq", sequenceName = "order_item_seq", initialValue =1, allocationSize = 1 )
public class OrderItem {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_item_seq")
	@Column(name="order_item_id")
	private int orderItemId;
	
	@Column(name="order_id")
	private int orderId;
	
	@Column(name="product_id")
	private int productId;
	
	@Column(name="product_title")
	private String productTitle;
	
	@Column(name="product_description")
	private String productDescription;
	
	@Column(name="product_code")
	private String productCode;
	
	@Column(name="product_img")
	private String productImg;
	
	@Column(name="product_category")
	private String productCategory;
	
	@Column(name="price")
	private int price;
	
	@Column(name="quantity")
	private int quantity;
	
	@Column(name="total_price")
	private int totalPrice;
}
