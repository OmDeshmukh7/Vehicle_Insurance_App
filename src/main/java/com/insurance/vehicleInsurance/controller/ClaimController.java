package com.insurance.vehicleInsurance.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.insurance.vehicleInsurance.entity.Claim;
import com.insurance.vehicleInsurance.exception.ClaimException;
import com.insurance.vehicleInsurance.service.ClaimService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
public class ClaimController {
		
		@Autowired
		ClaimService claimService;
		
		@PostMapping("/addClaim/")
		public Claim addClaim (@RequestBody Claim claim) throws ClaimException {
			return this.claimService.addClaim(claim);
		}

		@GetMapping("/findCustomer/{id}")
		public Claim getClaimById(@PathVariable Integer id) throws ClaimException {
			return this.claimService.getClaimById(id);
		}

		@PutMapping("/updateClaim/")
		public ResponseEntity<Claim> replaceCustomer(@RequestBody Claim updateClaim) throws ClaimException {
			Claim claim = this.claimService.updateClaim(updateClaim);
			return new ResponseEntity<Claim>(claim, HttpStatus.OK);
		}

		@GetMapping("/getAllClaims/")
		@ResponseStatus(HttpStatus.OK)
		public List<Claim> getAllClaim() {
			List<Claim> claimList = this.claimService.getAllClaims();
			return claimList;
		}
}
