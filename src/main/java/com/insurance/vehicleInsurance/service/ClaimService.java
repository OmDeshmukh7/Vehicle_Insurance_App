package com.insurance.vehicleInsurance.service;

import java.util.List;

import com.insurance.vehicleInsurance.entity.Claim;
import com.insurance.vehicleInsurance.exception.ClaimException;

public interface ClaimService {
	
	Claim addClaim(Claim newClaim) throws ClaimException;

	List<Claim> getClaimsByInsuranceId(Integer insuranceId) throws ClaimException;
	
	List<Claim> getAllClaims()throws ClaimException;
	
	String updateClaimStatusToApproved(Integer id) throws ClaimException;
	
	String updateClaimStatusToRejected(Integer id) throws ClaimException;
}
