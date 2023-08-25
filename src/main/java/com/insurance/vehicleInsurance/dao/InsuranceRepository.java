package com.insurance.vehicleInsurance.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.insurance.vehicleInsurance.entity.Insurance;

public interface InsuranceRepository extends JpaRepository<Insurance, Integer>{

}
