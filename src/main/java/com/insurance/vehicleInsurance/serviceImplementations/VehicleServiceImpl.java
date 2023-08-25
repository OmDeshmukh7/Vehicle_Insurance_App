package com.insurance.vehicleInsurance.serviceImplementations;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insurance.vehicleInsurance.dao.VehicleRepository;
import com.insurance.vehicleInsurance.entity.Vehicle;
import com.insurance.vehicleInsurance.exception.VehicleException;
import com.insurance.vehicleInsurance.service.VehicleService;

@Service
public class VehicleServiceImpl implements VehicleService{
	
	@Autowired
	VehicleRepository vehicleRepository;

	@Override
	public Vehicle addVehicle(Vehicle newVehicle) throws VehicleException {
		Optional<Vehicle> vehicleOpt = this.vehicleRepository.findById(newVehicle.getVehicleId());
		if(vehicleOpt.isPresent())
			throw new VehicleException("Vehicle already exists"+newVehicle.getVehicleName());
		return this.vehicleRepository.save(newVehicle);
	}

	@Override
	public Vehicle getVehicleById(Integer id) throws VehicleException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vehicle updateVehicle(Vehicle newVehicle) throws VehicleException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vehicle deleteVehicleById(Integer id) throws VehicleException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Vehicle> getAllVehicle() {
		// TODO Auto-generated method stub
		return null;
	}

}
