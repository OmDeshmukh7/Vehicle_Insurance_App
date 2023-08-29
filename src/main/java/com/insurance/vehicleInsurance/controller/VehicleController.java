package com.insurance.vehicleInsurance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.insurance.vehicleInsurance.dao.VehicleRepository;
import com.insurance.vehicleInsurance.dto.VehicleDto;
import com.insurance.vehicleInsurance.entity.Vehicle;

@RestController
public class VehicleController {

	@Autowired
	VehicleRepository vehicleRepo;
	
	@PostMapping("/vehicle/")
	public Vehicle addVehicle (@RequestBody VehicleDto vehicleDto) {
		Vehicle vehicle = new Vehicle(vehicleDto.getVehicleName(),vehicleDto.getVehicleRegNumber(),vehicleDto.getVehicleType());
		return this.vehicleRepo.save(vehicle);
	}
}
