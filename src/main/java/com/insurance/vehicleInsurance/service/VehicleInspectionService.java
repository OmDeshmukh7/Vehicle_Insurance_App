package com.insurance.vehicleInsurance.service;

import java.util.List;

import com.insurance.vehicleInsurance.entity.VehicleInspection;
import com.insurance.vehicleInsurance.exception.VehicleInspectionException;

public interface VehicleInspectionService {

	VehicleInspection addInspection(VehicleInspection newInspection)throws VehicleInspectionException;
	
	VehicleInspection getInspectionById(Integer id)throws VehicleInspectionException;
	
	VehicleInspection updateInspection(VehicleInspection newInspection)throws VehicleInspectionException;

	List<VehicleInspection>getAllInspections();
}
