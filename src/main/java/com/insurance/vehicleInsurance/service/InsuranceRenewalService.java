package com.insurance.vehicleInsurance.service;

import java.util.List;

import com.insurance.vehicleInsurance.entity.InsuranceRenewal;
import com.insurance.vehicleInsurance.exception.InsuranceRenewalException;

public interface InsuranceRenewalService {

	public String sendInsuranceRenewalReminder(Integer insuranceNumber) throws InsuranceRenewalException;
	
}
