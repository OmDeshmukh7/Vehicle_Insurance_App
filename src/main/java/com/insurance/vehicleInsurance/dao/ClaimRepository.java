package com.insurance.vehicleInsurance.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.insurance.vehicleInsurance.entity.Claim;

public interface ClaimRepository extends JpaRepository<Claim, Integer>{

}
