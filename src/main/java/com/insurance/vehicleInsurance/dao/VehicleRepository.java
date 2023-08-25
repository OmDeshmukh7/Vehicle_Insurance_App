package com.insurance.vehicleInsurance.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.insurance.vehicleInsurance.entity.Vehicle;

public interface VehicleRepository extends JpaRepository<Vehicle, Integer>{

}
