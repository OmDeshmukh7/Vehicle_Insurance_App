package com.insurance.vehicleInsurance.service;

import java.util.List;

import com.insurance.vehicleInsurance.entity.Documents;
import com.insurance.vehicleInsurance.exception.DocumentException;

public interface DocumentService {
	
	Documents addLicense(Documents newLicense)throws DocumentException;
	
	Documents getLicenseById(Integer id)throws DocumentException;
	
	Documents updateLicense(Documents newLicense)throws DocumentException;
	
	Documents deleteLicenseById(Integer id)throws DocumentException;
	
	List<Documents>getAllLicense();

}
