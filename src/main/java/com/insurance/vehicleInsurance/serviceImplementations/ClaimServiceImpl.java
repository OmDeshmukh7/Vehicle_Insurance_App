package com.insurance.vehicleInsurance.serviceImplementations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insurance.vehicleInsurance.dao.ClaimRepository;
import com.insurance.vehicleInsurance.dao.EndUserRepository;
import com.insurance.vehicleInsurance.dao.InsuranceRepository;
import com.insurance.vehicleInsurance.entity.Claim;
import com.insurance.vehicleInsurance.entity.EndUser;
import com.insurance.vehicleInsurance.entity.Insurance;
import com.insurance.vehicleInsurance.exception.ClaimException;
import com.insurance.vehicleInsurance.service.ClaimService;

/*Implements all the methods related to the claims adding a claim, getting a claim, updating claim status. */

@Service
public class ClaimServiceImpl implements ClaimService {

	@Autowired
	ClaimRepository claimRepository;
	
	@Autowired
	InsuranceRepository insuranceRepository;
	
	@Autowired
	EndUserRepository endUserRepository;

	@Override
	public Claim addClaim(Claim newClaim) throws ClaimException {
		
		
		Optional<Insurance> insuranceOpt = this.insuranceRepository.findById(newClaim.getInsuranceId());
		
		if(!insuranceOpt.isPresent()) {
			throw new ClaimException("No valid Insurance present.");
		}
		this.claimRepository.save(newClaim);
		Optional<EndUser> endUserOpt = this.endUserRepository.findById(newClaim.getEndUserId());
		
		EndUser endUser = endUserOpt.get();
		Insurance insurance = insuranceOpt.get();
		List<Claim> claimList = new ArrayList<Claim>();
		claimList.add(newClaim);
		endUser.setClaims(claimList);
		insurance.setClaims(claimList);
		this.endUserRepository.save(endUser);
		this.insuranceRepository.save(insurance);
		return newClaim;
	}

	@Override
	public List<Claim> getClaimsByInsuranceId(Integer insuranceId) throws ClaimException {
	    Optional<Insurance> insuranceOpt = this.insuranceRepository.findById(insuranceId);
	    if (!insuranceOpt.isPresent()) {
	        throw new ClaimException("Insurance policy not found by id: " + insuranceId);
	    }
	    Insurance insurance = insuranceOpt.get();
	    List<Claim> claims = claimRepository.findByInsuranceId(insurance.getInsuranceId());
	    return claims;
	}

	@Override
	public List<Claim> getAllClaims() throws ClaimException {
		return this.claimRepository.findAll();
	}

	@Override
	public String updateClaimStatusToApproved(Integer id) throws ClaimException {
		Optional<Claim> claimOpt = this.claimRepository.findById(id);
		if(!claimOpt.isPresent()) {
			throw new ClaimException("There is no claim present by id: "+id);
		}
		Claim claim = claimOpt.get();
		claim.setClaimStatus("Approved");
		this.claimRepository.save(claim);
		return "Approved";
	}

	@Override
	public String updateClaimStatusToRejected(Integer id) throws ClaimException {
		Optional<Claim> claimOpt = this.claimRepository.findById(id);
		if(!claimOpt.isPresent()) {
			throw new ClaimException("There is no claim present by id: "+id);
		}
		Claim claim = claimOpt.get();
		claim.setClaimStatus("Rejected");
		this.claimRepository.save(claim);
		return "Rejected";
	}

}
