package com.insurance.vehicleInsurance.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.insurance.vehicleInsurance.entity.InsuranceRenewal;

public interface InsuranceRenewalRepository extends JpaRepository<InsuranceRenewal, Integer>{

}
