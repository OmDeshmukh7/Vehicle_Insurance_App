package com.insurance.vehicleInsurance.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.insurance.vehicleInsurance.entity.Vehicle;

public interface VehicleRepository extends JpaRepository<Vehicle, Integer>{

	Optional<Vehicle> findByVehicleRegNumber(String registrationNumber);
}
