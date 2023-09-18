package com.insurance.vehicleInsurance.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.insurance.vehicleInsurance.dto.EndUserDto;
import com.insurance.vehicleInsurance.entity.Claim;
import com.insurance.vehicleInsurance.entity.EndUser;
import com.insurance.vehicleInsurance.exception.ClaimException;
import com.insurance.vehicleInsurance.exception.EndUserException;
import com.insurance.vehicleInsurance.service.ClaimService;

@RestController
@CrossOrigin(origins="http://localhost:4200/")
public class ClaimController {

	@Autowired

	ClaimService claimService;

	@PostMapping("/Claim/new/")
	public Claim addClaim(@RequestBody Claim newClaim) throws ClaimException {
		return this.claimService.addClaim(newClaim);
	}

	@GetMapping("/claim/{id}")
	public ResponseEntity<List<Claim>> getClaimsByInsuranceId(@PathVariable Integer insuranceId) throws ClaimException {
		List<Claim> claims = claimService.getClaimsByInsuranceId(insuranceId);
		return ResponseEntity.ok(claims);
	}

	@GetMapping("/Claims/")
	public List<Claim> getAllClaims() throws ClaimException {
		return this.claimService.getAllClaims();
	}
	
	@PutMapping("/claim/status/{id}")
	public ResponseEntity<String> updateClaimStatusToApprove(@PathVariable Integer id) throws ClaimException {
		String claim = this.claimService.updateClaimStatusToApproved(id);
		return new ResponseEntity<String>(claim, HttpStatus.OK);
	}
	
	@PutMapping("/claim/reject/{id}")
	public ResponseEntity<String> updateClaimStatusToReject(@PathVariable Integer id) throws ClaimException {
		String claim = this.claimService.updateClaimStatusToRejected(id);
		return new ResponseEntity<String>(claim, HttpStatus.OK);
	}
}
