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
 * Product order model
 * 
 * @author khanw
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "orders")
@SequenceGenerator(name="order_seq", sequenceName = "order_seq", initialValue =1, allocationSize = 1 )
public class Order {

	// order details properties
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_seq")
	@Column(name = "order_id")
	private int orderId;

	@Column(name = "order_date")
	private Date orderDate = new Date();

	@Column(name = "order_status")
	private String orderStatus;

	// pricing properties
	@Column(name = "total_items")
	private int totalItems;

	@Column(name = "items_sub_total")
	private int itemsSubTotal;

	@Column(name = "shipment_charges")
	private int shipmentCharges;

	@Column(name = "total_amount")
	private int totalAmount;

	@Column(name = "payment_status")
	private int paymentStatus;

	// payment status properties
	@Column(name = "payment_status_title")
	private String paymentStatusTitle;

	@Column(name = "payment_method")
	private int paymentMethod;

	@Column(name = "payment_method_title")
	private String paymentMethodTitle;

	// customer mapping user properties
	@Column(name = "user_id")
	private int userId;

	@Column(name = "email")
	private String email;

	@Column(name = "address")
	private String address;

	@Column(name = "user_name")
	private String name;

	@Column(name = "contact")
	private Long contact;
}
