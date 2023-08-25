package com.insurance.vehicleInsurance.service;

import java.util.List;

import com.insurance.vehicleInsurance.entity.Claim;
import com.insurance.vehicleInsurance.exception.ClaimException;

public interface ClaimService {
	
	Claim addClaim(Claim newClaim)throws ClaimException;
	
	Claim getClaimById(Integer id)throws ClaimException;
	
	Claim updateClaim(Claim newClaim)throws ClaimException;
	
	Claim deleteClaimById(Integer id)throws ClaimException;
	
	List<Claim>getAllClaims();
}
