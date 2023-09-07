package com.insurance.vehicleInsurance.serviceImplementations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.insurance.vehicleInsurance.dao.CustomerRepository;
import com.insurance.vehicleInsurance.dao.InsuranceRepository;
import com.insurance.vehicleInsurance.dao.VehicleRepository;
import com.insurance.vehicleInsurance.dto.VehicleDto;
import com.insurance.vehicleInsurance.entity.Customer;
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
	CustomerRepository customerRepository;

	@Override
	public Vehicle addVehicle(VehicleDto newVehicle) throws VehicleException {
		Optional<Customer> customerOpt = this.customerRepository.findById(newVehicle.getCustomerId());
		if (!customerOpt.isPresent()) {
			throw new VehicleException("No Customer is present with id: " + newVehicle.getCustomerId());
		}
		Optional<Vehicle> existingVehicle = findByVehicleRegNumber(newVehicle.getVehicleRegNumber());
		if (existingVehicle.isPresent()) {
			throw new VehicleException("A vehicle with the same registration number already exists.");
		}
		Vehicle vehicle = new Vehicle(newVehicle.getVehicleType(), newVehicle.getVehicleRegNumber(),
				newVehicle.getVehicleName(), newVehicle.getCustomerId());
		vehicleRepository.save(vehicle);
		Customer customer = customerOpt.get();
		List<Vehicle> vehicles = new ArrayList<Vehicle>();
		vehicles.add(vehicle);
		customer.setVehicles(vehicles);
		this.customerRepository.save(customer);
		return vehicle;
	}

	@Override
	public Vehicle getVehicleById(Integer id) throws VehicleException {
		Optional<Vehicle> vehicleOpt = this.vehicleRepository.findById(id);
		if (!vehicleOpt.isPresent()) {
			throw new VehicleException("Vehicle not found by id: " + id);
		}
		return vehicleOpt.get();
	}

	@Override
	public Vehicle updateVehicle(VehicleDto newVehicle) throws VehicleException {
		if (newVehicle == null) {
			throw new VehicleException("Please enter valid values.");
		}
		Vehicle vehicle = new Vehicle(newVehicle.getVehicleType(), newVehicle.getVehicleRegNumber(),
				newVehicle.getVehicleName(), newVehicle.getCustomerId());
		return this.vehicleRepository.save(vehicle);
	}

	@Override
	public Vehicle deleteVehicleById(Integer id) throws VehicleException {
		Optional<Vehicle> vehicleOpt = this.vehicleRepository.findById(id);
		if (vehicleOpt == null) {
			throw new VehicleException("Vehicle not Found to delete, id: " + id);
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
