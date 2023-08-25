package com.insurance.vehicleInsurance.service;

import java.util.List;

import com.insurance.vehicleInsurance.entity.Insurance;
import com.insurance.vehicleInsurance.exception.InsuranceException;

public interface InsuranceService {
	
	Insurance addInsurance(Insurance newInsurance)throws InsuranceException;

	Insurance getInsuranceById(Integer id)throws InsuranceException;
	
	Insurance updateinsurance(Insurance newInsurance)throws InsuranceException;
	
	Insurance deleteInsuranceById(Integer id)throws InsuranceException;
	
	List<Insurance>getAllInsurance();
}
