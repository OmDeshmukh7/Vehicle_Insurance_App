package com.insurance.vehicleInsurance.serviceImplementations;



import org.springframework.stereotype.Service;
import com.insurance.vehicleInsurance.exception.InsuranceRenewalException;
import com.insurance.vehicleInsurance.service.InsuranceRenewalService;

@Service
public class InsuranceRenewalServiceImpl implements InsuranceRenewalService{

/* sends a reminder to renew insurance after the insurance is expired */

	@Override
	public String sendInsuranceRenewalReminder(Integer insuranceNumber) throws InsuranceRenewalException {
		
		return null;
	}


}
