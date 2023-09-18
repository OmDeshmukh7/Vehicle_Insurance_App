package com.insurance.vehicleInsurance.serviceImplementations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.insurance.vehicleInsurance.dao.EndUserRepository;
import com.insurance.vehicleInsurance.dao.InsuranceRepository;
import com.insurance.vehicleInsurance.dao.VehicleRepository;
import com.insurance.vehicleInsurance.dto.VehicleDto;
import com.insurance.vehicleInsurance.entity.EndUser;
import com.insurance.vehicleInsurance.entity.Vehicle;
import com.insurance.vehicleInsurance.exception.VehicleException;
import com.insurance.vehicleInsurance.service.VehicleService;

@Service
public class VehicleServiceImpl implements VehicleService {

	@Autowired
	VehicleRepository vehicleRepository;

	@Autowired
	InsuranceRepository insuranceRepository;

	@Autowired
	EndUserRepository endUserRepository;

	@Override
	public Vehicle addVehicle(VehicleDto newVehicle) throws VehicleException {
		Optional<EndUser> endUserOpt = this.endUserRepository.findById(newVehicle.getEndUserId());
		if (!endUserOpt.isPresent()) {
			throw new VehicleException("No Customer is present with id: " + newVehicle.getEndUserId());
		}
		Optional<Vehicle> existingVehicle = findByVehicleRegNumber(newVehicle.getVehicleRegNumber());
		if (existingVehicle.isPresent()) {
			throw new VehicleException("A vehicle with the same registration number already exists.");
		}
		Vehicle vehicle = new Vehicle(newVehicle.getVehicleType(), newVehicle.getVehicleRegNumber(),
				newVehicle.getVehicleName(), newVehicle.getEndUserId());
		vehicleRepository.save(vehicle);
		EndUser customer = endUserOpt.get();
		List<Vehicle> vehicles = new ArrayList<Vehicle>();
		vehicles.add(vehicle);
		customer.setVehicles(vehicles);
		this.endUserRepository.save(customer);
		return vehicle;
	}

	@Override
	public Vehicle getVehicleByRegistrationNumber (String registrationNumber) throws VehicleException {
		Optional<Vehicle> vehicleOpt = this.vehicleRepository.findByVehicleRegNumber(registrationNumber);
		if (!vehicleOpt.isPresent()) {
			throw new VehicleException("Vehicle not found " + registrationNumber);
		}
		return vehicleOpt.get();
	}

	@Override
	public Vehicle updateVehicle(VehicleDto newVehicle) throws VehicleException {
		if (newVehicle == null) {
			throw new VehicleException("Please enter valid values.");
		}
		Vehicle vehicle = new Vehicle(newVehicle.getVehicleType(), newVehicle.getVehicleRegNumber(),
				newVehicle.getVehicleName(), newVehicle.getEndUserId());
		return this.vehicleRepository.save(vehicle);
	}

	@Override
	public Vehicle deleteVehicleById(String registrationNumber) throws VehicleException {
		Optional<Vehicle> vehicleOpt = this.vehicleRepository.findByVehicleRegNumber(registrationNumber);
		if (vehicleOpt == null) {
			throw new VehicleException("Vehicle not Found to delete, id: " + registrationNumber);
		}
		Vehicle vehicle = vehicleOpt.get();
		this.vehicleRepository.delete(vehicle);
		return vehicle;
	}

	@Override
	public List<Vehicle> getAllVehicle() {
		return this.vehicleRepository.findAll();
	}

	@Override
	public Optional<Vehicle> findByVehicleRegNumber(String registrationNumber) throws VehicleException {
		return vehicleRepository.findByVehicleRegNumber(registrationNumber);
	}
}
