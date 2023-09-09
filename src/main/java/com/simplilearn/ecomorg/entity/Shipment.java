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

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "shipment_details")
@SequenceGenerator(name="shipment_seq", sequenceName = "shipment_seq", initialValue =1, allocationSize = 1 )
public class Shipment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "shipment_seq")
	@Column(name="shipment_id")
	private int shipmentId;
	
	@Column(name="order_id")
	private int orderId;
	
	@Column(name="shipment_status")
	private int shipmentStatus;
	
	@Column(name="shipment_title")
	private String shipmentTitle;
	
	@Column(name="shipment_date")
	private Date shipmentDate;
	
	@Column(name="expected_delivery_date")
	private Date expectedDeliveryDate;
	
	@Column(name="shipment_method")
	private String shipmentMethod;
	
	@Column(name="shipment_company")
	private String shipmentCompany;

}
