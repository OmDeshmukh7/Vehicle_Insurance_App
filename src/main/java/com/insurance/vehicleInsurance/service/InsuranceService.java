package com.insurance.vehicleInsurance.service;

import java.util.List;

import com.insurance.vehicleInsurance.dto.InsuranceDto;
import com.insurance.vehicleInsurance.entity.Insurance;
import com.insurance.vehicleInsurance.exception.ClaimException;
import com.insurance.vehicleInsurance.exception.InsuranceException;

public interface InsuranceService {
	
	public Insurance addInsurance(InsuranceDto newInsurance) throws InsuranceException;
	
	public Insurance getInsuranceByInsuranceNumber(String insuranceNumber) throws InsuranceException;
	
	List<Insurance>getAllInsurance();
	
    String updateInsuranceStatusToApproved(Integer id) throws InsuranceException;
	
	String updateInsuranceStatusToRejected(Integer id) throws InsuranceException;
}
