package com.insurance.vehicleInsurance.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.insurance.vehicleInsurance.entity.VehicleInspection;

public interface VehicleInspectionRepository extends JpaRepository<VehicleInspection, Integer>{

}
