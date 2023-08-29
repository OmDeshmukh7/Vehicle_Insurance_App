package com.insurance.vehicleInsurance.service;

import java.util.List;

import com.insurance.vehicleInsurance.entity.Documents;
import com.insurance.vehicleInsurance.exception.DocumentException;

public interface DocumentService {
	
	Documents addDocument(Documents newLicense)throws DocumentException;
	
	Documents getDocumentById(Integer id)throws DocumentException;
	
	Documents updateDocument(Documents newLicense)throws DocumentException;
	
	Documents deleteDocumentById(Integer id)throws DocumentException;
	
	List<Documents>getAllDocuments();

}
