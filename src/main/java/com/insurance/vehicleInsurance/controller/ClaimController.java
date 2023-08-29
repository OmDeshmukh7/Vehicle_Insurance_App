package com.insurance.vehicleInsurance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.insurance.vehicleInsurance.entity.Claim;
import com.insurance.vehicleInsurance.service.ClaimService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
public class ClaimController {
		
		@Autowired
		ClaimService claimService;
		
				
}
