package com.insurance.vehicleInsurance.service;

import java.util.List;

import com.insurance.vehicleInsurance.entity.Registration;
import com.insurance.vehicleInsurance.exception.RegistrationException;

public interface RegistrationService {
	
	Registration addRegistration(Registration newRegistration)throws RegistrationException;
	
	Registration getRegistrationById(Integer id)throws RegistrationException;
	
	Registration updateRegistration(Registration newRegistration)throws RegistrationException;
	
	Registration deleteRegistration(Integer id)throws RegistrationException;
	
	List<Registration>getAllRegistrations();

}
