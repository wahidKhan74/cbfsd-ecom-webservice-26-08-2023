package com.simplilearn.ecomorg.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplilearn.ecomorg.entity.Shipment;
import com.simplilearn.ecomorg.exception.BadRequestException;
import com.simplilearn.ecomorg.exception.NotFoundException;
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
	public Optional<Shipment> getShipment(int shipmentId) {
		Optional<Shipment> shipment = shipmentRepository.findById(shipmentId);
		if (shipment.isPresent()) {
			return shipment;
		} else
			throw new NotFoundException("The shipment details does not exist with provided Id.");
	}

	// Add shipment
	public Shipment addShipment(Shipment shipment) {
		return shipmentRepository.save(shipment);
	}

	// Update shipment
	public Shipment updateShipment(Shipment shipment) {
		if (shipment.getShipmentId() <= 0)
			throw new BadRequestException("shipment id cannot be null or empty.");
		if (shipmentRepository.existsById(shipment.getShipmentId()))
			return shipmentRepository.save(shipment);
		else
			throw new NotFoundException("The shipment details does not exist with provided Id.");
	}

	// Delete shipment
	public void deleteShipment(int shipmentId) {
		if (shipmentId <= 0)
			throw new BadRequestException("shipment id cannot be null or empty.");
		if (shipmentRepository.existsById(shipmentId))
			shipmentRepository.deleteById(shipmentId);
		else
			throw new NotFoundException("The shipment details does not exist with provided Id.");
	}
}
