package com.insurance.vehicleInsurance.service;

import java.util.List;

import com.insurance.vehicleInsurance.dto.VehicleDto;
import com.insurance.vehicleInsurance.entity.Vehicle;
import com.insurance.vehicleInsurance.exception.VehicleException;

public interface VehicleService {
	
	Vehicle addVehicle(VehicleDto newVehicle)throws VehicleException;
	
	Vehicle getVehicleById(Integer id)throws VehicleException;
	
	Vehicle updateVehicle(Vehicle newVehicle)throws VehicleException;
	
	Vehicle deleteVehicleById(Integer id)throws VehicleException;
	
	List<Vehicle>getAllVehicle();
	

}
