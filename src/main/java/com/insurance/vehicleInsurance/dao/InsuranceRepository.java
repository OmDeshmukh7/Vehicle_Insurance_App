package com.insurance.vehicleInsurance.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.insurance.vehicleInsurance.entity.Insurance;

public interface InsuranceRepository extends JpaRepository<Insurance, Integer>{

	Optional<Insurance> findByInsuranceNumber(String insuranceNumber);

}
