package com.insurance.vehicleInsurance.serviceImplementations;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insurance.vehicleInsurance.dao.ClaimRepository;
import com.insurance.vehicleInsurance.entity.Claim;
import com.insurance.vehicleInsurance.exception.ClaimException;
import com.insurance.vehicleInsurance.service.ClaimService;

@Service
public class ClaimServiceImpl implements ClaimService{

	@Autowired
	ClaimRepository claimRepository;
	
	@Override
	public Claim getClaimById(Integer id) throws ClaimException {
	Optional<Claim> claimOpt = this.claimRepository.findById(id); if(!claimOpt.isPresent()) {
	throw new ClaimException("Claim not found for id: "+id); }
	return claimOpt.get(); 
	}
	
	@Override
	public Claim updateClaim(Claim newClaim) throws ClaimException {
	return this.claimRepository.save(newClaim); 
	}
	
	@Override
	public Claim addClaim(Claim newClaim) throws ClaimException {
	Optional<Claim> claimOpt = this.claimRepository.findById(newClaim.getClaimId());
	if(claimOpt.isPresent()) {
	throw new ClaimException("Claim already exist"); 
	}
	Claim addedClaim = claimRepository.save(newClaim);
	return addedClaim; 
	}
	
	@Override
	public List<Claim> getAllClaims() {
	return this.claimRepository.findAll(); 
	}
}

