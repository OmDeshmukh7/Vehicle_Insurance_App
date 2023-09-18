package com.insurance.vehicleInsurance.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.insurance.vehicleInsurance.entity.VehicleInspection;
import com.insurance.vehicleInsurance.exception.VehicleInspectionException;
import com.insurance.vehicleInsurance.service.VehicleInspectionService;

@RestController
@CrossOrigin(origins="http://localhost:4200/")
public class VehicleInspectionController {
	
	@Autowired
	VehicleInspectionService vehicleInspectionService;

	@PostMapping("/Inspection/")
	public VehicleInspection addVehicleInspection(@RequestBody VehicleInspection vehicleInspection)
			throws VehicleInspectionException {
		return this.vehicleInspectionService.addInspection(vehicleInspection);
	}

	@GetMapping("/Inspection/{id}")
	public VehicleInspection getVehicleInspectionById(@PathVariable Integer id) throws VehicleInspectionException {
		return this.vehicleInspectionService.getInspectionById(id);
	}

//	@PutMapping("/updateVehicleInspection/")
//	public ResponseEntity<VehicleInspection> replaceVehicleInspection(
//			@RequestBody VehicleInspection updateVehicleInspection) throws VehicleInspectionException {
//		VehicleInspection vehicleInspection = this.vehicleInspectionService.updateInspection(updateVehicleInspection);
//		return new ResponseEntity<VehicleInspection>(vehicleInspection, HttpStatus.OK);
//	}

	@GetMapping("/Inspections/")
	@ResponseStatus(HttpStatus.OK)
	public List<VehicleInspection> getAllVehicleInspections() {
		List<VehicleInspection> vehicleInspectionList = this.vehicleInspectionService.getAllInspections();
		return vehicleInspectionList;
	}

}
