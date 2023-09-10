package com.simplilearn.ecomorg.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.simplilearn.ecomorg.dto.ResponseDto;
import com.simplilearn.ecomorg.entity.Shipment;
import com.simplilearn.ecomorg.service.ShipmentService;

// CRUD operation for shipment
@RestController
public class ShipmentController {

	@Autowired 
	ShipmentService shipmentService;
	
	
	@GetMapping("/shipments")
	public List<Shipment> getShipments(){
		return shipmentService.getShipments();
	}
	
	@GetMapping("/shipments/{shipmentId}")
	public ResponseDto getShipment(@PathVariable int shipmentId){
		Optional<Shipment> shipment = shipmentService.getShipment(shipmentId);
		return new ResponseDto("Shipment is found sucessfully with shipmentId : "+shipmentId, new Date(),HttpStatus.OK.name(),shipment);
	}
	
	@PostMapping("/shipments")
	public ResponseDto addShipment(@RequestBody Shipment shipment){
		Shipment shipmentCreated = shipmentService.addShipment(shipment);
		return new ResponseDto("Shipment is created sucessfully.", new Date(),HttpStatus.OK.name(),shipmentCreated);
	}
	
	@PutMapping("/shipments")
	public ResponseDto updateShipment(@RequestBody Shipment shipment){
		Shipment shipmentUpdated = shipmentService.updateShipment(shipment);
		return new ResponseDto("Shipment is updated sucessfully.", new Date(),HttpStatus.OK.name(),shipmentUpdated);
	}
	
	@DeleteMapping("/shipments/{shipmentId}")
	public ResponseDto updateShipment(@PathVariable int shipmentId){
		shipmentService.deleteShipment(shipmentId);
		return new ResponseDto("Shipment is deleted sucessfully with shipmentId : "+shipmentId, new Date(),HttpStatus.OK.name(),null);
	}
}
