package com.insurance.vehicleInsurance.serviceImplementations;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insurance.vehicleInsurance.dao.InsuranceRepository;
import com.insurance.vehicleInsurance.dao.VehicleRepository;
import com.insurance.vehicleInsurance.dto.VehicleDto;
import com.insurance.vehicleInsurance.entity.Vehicle;
import com.insurance.vehicleInsurance.exception.VehicleException;
import com.insurance.vehicleInsurance.service.VehicleService;

@Service
public class VehicleServiceImpl implements VehicleService{
	
	@Autowired
	VehicleRepository vehicleRepository;
	
	@Autowired
	InsuranceRepository insuranceRepository;

	@Override
	public Vehicle addVehicle(VehicleDto newVehicle) throws VehicleException {
		Optional<Vehicle> vehicleOpt = this.vehicleRepository.findByVehicleRegNumber(newVehicle.getVehicleRegNumber());
		if(vehicleOpt.isPresent()) {
			throw new VehicleException("Vehicle already exists"+newVehicle.getVehicleName());
		}
//		Insurance insurance = newVehicle.getInsurance();
//		if(insurance != null) {
//			insurance = this.insuranceRepository.save(insurance);
//		}newVehicle.setInsurance(insurance);
		Vehicle vehicle = new Vehicle(newVehicle.getVehicleRegNumber(),newVehicle.getVehicleType(),newVehicle.getVehicleName());
		return this.vehicleRepository.save(vehicle);
	}

	@Override
	public Vehicle getVehicleById(Integer id) throws VehicleException {
		Optional<Vehicle> vehicleOpt = this.vehicleRepository.findById(id);
		if(!vehicleOpt.isPresent()) {
			throw new VehicleException("Vehicle not found by id: "+id);
		}
		return vehicleOpt.get();
	}

	@Override
	public Vehicle updateVehicle(Vehicle newVehicle) throws VehicleException {
		if(newVehicle==null) {
			throw new VehicleException("Please enter valid values.");
		}
		return this.vehicleRepository.save(newVehicle);
	}

	@Override
	public Vehicle deleteVehicleById(Integer id) throws VehicleException {
		Optional<Vehicle> vehicleOpt = this.vehicleRepository.findById(id);
		if(vehicleOpt == null) {
			throw new VehicleException("Vehicle not Found to delete, id: "+id);
		}
		Vehicle vehicle = vehicleOpt.get();
		this.vehicleRepository.delete(vehicle);
		return vehicle;
	}

	@Override
	public List<Vehicle> getAllVehicle() {
		return this.vehicleRepository.findAll();
	}

}
