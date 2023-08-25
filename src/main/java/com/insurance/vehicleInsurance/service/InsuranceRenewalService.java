package com.insurance.vehicleInsurance.service;

import java.util.List;

import com.insurance.vehicleInsurance.entity.InsuranceRenewal;
import com.insurance.vehicleInsurance.exception.InsuranceRenewalException;

public interface InsuranceRenewalService {

	InsuranceRenewal addInsuranceRenewal(InsuranceRenewal newInsuranceRenewal)throws InsuranceRenewalException;
	
	InsuranceRenewal getInsuranceRenewalById(Integer id)throws InsuranceRenewalException;
	
	InsuranceRenewal deleteInsuranceRenewalById(Integer id)throws InsuranceRenewalException;
	
	List<InsuranceRenewal>getAllInsuranceRenewals();
	
}
