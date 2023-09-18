package com.insurance.vehicleInsurance.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.insurance.vehicleInsurance.dto.VehicleDto;
import com.insurance.vehicleInsurance.entity.Vehicle;
import com.insurance.vehicleInsurance.exception.VehicleException;
import com.insurance.vehicleInsurance.service.VehicleService;

@RestController
@CrossOrigin(origins="http://localhost:4200/")
public class VehicleController {

	@Autowired
	VehicleService vehicleService;
	
	@PostMapping("/Vehicle/new")
    public ResponseEntity<?> addNewVehicle(@RequestBody VehicleDto newVehicle) {
        try {
            Vehicle savedVehicle = vehicleService.addVehicle(newVehicle);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedVehicle);
        } catch (VehicleException ex) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
        }
    }
	
	  @GetMapping("/Vehicle/")
	    public ResponseEntity<Vehicle> findVehicleByRegistrationNumber(@RequestParam String registrationNumber) throws VehicleException {
	        Optional<Vehicle> vehicle = vehicleService.findByVehicleRegNumber(registrationNumber);
	        if (vehicle.isPresent()) {
	            return ResponseEntity.ok(vehicle.get());
	        } else {
	        	throw new VehicleException("Vehicle does not exist."+ResponseEntity.notFound().build());
	        }
	    }
	  
	  @PutMapping("/Vehicle/edit")
	  public ResponseEntity<Vehicle> updateExistingVehicle(@RequestBody VehicleDto newVehicle) throws VehicleException{
		  Vehicle vehicle = this.vehicleService.updateVehicle(newVehicle);
		  return new ResponseEntity<Vehicle>(vehicle,HttpStatus.OK);
	  }
	  
	  @GetMapping("/Vehicles/")
	  @ResponseStatus(HttpStatus.OK)
	  public List<Vehicle> getAllVehicles(){
		  List<Vehicle> vehicleList = this.vehicleService.getAllVehicle();
		  return vehicleList;
	  }
}
