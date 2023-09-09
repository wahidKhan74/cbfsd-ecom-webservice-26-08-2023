package com.simplilearn.ecomorg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplilearn.ecomorg.entity.Shipment;
import com.simplilearn.ecomorg.repository.ShipmentRepository;

@Service
public class ShipmentService {

	@Autowired
	ShipmentRepository shipmentRepository;
	
	// Get all shipments
	public List<Shipment> getShipments() {
		return shipmentRepository.findAll();
	}
	
	// Get one shipment by shipmentId
	public Shipment getShipment(int shipmentId) {
		return shipmentRepository.findById(shipmentId).get();
	}
	
	// Add shipment
	public Shipment addShipment(Shipment shipment) {
		return shipmentRepository.save(shipment);
	}
	
	// Update shipment
	public Shipment updateShipment(Shipment shipment) {
		if(shipmentRepository.existsById(shipment.getShipmentId()))
			return shipmentRepository.save(shipment);
		else 
			return null;
	}
	
	// Delete shipment
	public void deleteShipment(int shipmentId) {
		shipmentRepository.deleteById(shipmentId);
	}
}
