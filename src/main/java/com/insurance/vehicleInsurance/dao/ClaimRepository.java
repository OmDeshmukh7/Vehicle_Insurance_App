package com.insurance.vehicleInsurance.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.insurance.vehicleInsurance.entity.Claim;

public interface ClaimRepository extends JpaRepository<Claim, Integer>{

	List<Claim> findByInsuranceId(Integer insuranceId);

}
