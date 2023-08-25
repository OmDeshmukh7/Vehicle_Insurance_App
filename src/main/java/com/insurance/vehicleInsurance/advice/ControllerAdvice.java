package com.insurance.vehicleInsurance.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.insurance.vehicleInsurance.exception.AdminException;
import com.insurance.vehicleInsurance.exception.ApprovalException;
import com.insurance.vehicleInsurance.exception.ClaimException;
import com.insurance.vehicleInsurance.exception.CustomerException;
import com.insurance.vehicleInsurance.exception.InsuranceException;
import com.insurance.vehicleInsurance.exception.InsuranceRenewalException;
import com.insurance.vehicleInsurance.exception.DocumentException;
import com.insurance.vehicleInsurance.exception.PaymentException;
import com.insurance.vehicleInsurance.exception.RegistrationException;
import com.insurance.vehicleInsurance.exception.VehicleException;
import com.insurance.vehicleInsurance.exception.VehicleInspectionException;

@RestControllerAdvice
public class ControllerAdvice {
	
	@ExceptionHandler(CustomerException.class)
	public ResponseEntity<String>handleCustomerException(CustomerException customerException){
		return new ResponseEntity<String>(customerException.getMessage(),HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(VehicleException.class)
	public ResponseEntity<String>handleVehicleException(VehicleException vehicleException){
		return new ResponseEntity<String>(vehicleException.getMessage(),HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(InsuranceException.class)
	public ResponseEntity<String>handleInsuranceException(InsuranceException insuranceException){
		return new ResponseEntity<String>(insuranceException.getMessage(),HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(DocumentException.class)
	public ResponseEntity<String>handleDocumentException(DocumentException documentException){
		return new ResponseEntity<String>(documentException.getMessage(),HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(PaymentException.class)
	public ResponseEntity<String>handlePaymentException(PaymentException paymentException){
		return new ResponseEntity<String>(paymentException.getMessage(),HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(RegistrationException.class)
	public ResponseEntity<String>handleRegistrationException(RegistrationException registrationException){
		return new ResponseEntity<String>(registrationException.getMessage(),HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(AdminException.class)
	public ResponseEntity<String>handleAdminException(AdminException adminException){
		return new ResponseEntity<String>(adminException.getMessage(),HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(ApprovalException.class)
	public ResponseEntity<String>handleApprovalException(ApprovalException approvalException){
		return new ResponseEntity<String>(approvalException.getMessage(),HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(ClaimException.class)
	public ResponseEntity<String>handleClaimException(ClaimException claimException){
		return new ResponseEntity<String>(claimException.getMessage(),HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(InsuranceRenewalException.class)
	public ResponseEntity<String>handleInsuranceRenewalException(InsuranceRenewalException insuranceRenewalException){
		return new ResponseEntity<String>(insuranceRenewalException.getMessage(),HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(VehicleInspectionException.class)
	public ResponseEntity<String>handleVehicleInspection(VehicleInspectionException vehicleInspectionException){
		return new ResponseEntity<String>(vehicleInspectionException.getMessage(),HttpStatus.BAD_REQUEST);
	}
}
