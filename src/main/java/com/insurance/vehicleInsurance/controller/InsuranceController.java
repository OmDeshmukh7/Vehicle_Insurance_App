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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.insurance.vehicleInsurance.dto.InsuranceDto;
import com.insurance.vehicleInsurance.entity.Insurance;
import com.insurance.vehicleInsurance.exception.ClaimException;
import com.insurance.vehicleInsurance.exception.InsuranceException;
import com.insurance.vehicleInsurance.service.InsuranceService;


@RestController
@CrossOrigin(origins="http://localhost:4200/")
public class InsuranceController {
	
	@Autowired
	InsuranceService insuranceService;
	
	@PostMapping("/Insurance/new")
	public Insurance addInsurance(@RequestBody InsuranceDto insurance) throws InsuranceException {
		return this.insuranceService.addInsurance(insurance);
	}
	
	@GetMapping("/Insurances/")
	@ResponseStatus(HttpStatus.OK)
	public List<Insurance > getAllInsurances() {
		List<Insurance> insuranceList = this.insuranceService.getAllInsurance();
		return insuranceList;
	}
	
	@GetMapping("/Insurance/{id}")
	public Insurance getInsuranceById(@PathVariable String insuranceNumber) throws InsuranceException {
		return this.insuranceService.getInsuranceByInsuranceNumber(insuranceNumber);
	}
	
	@PutMapping("/insurance/status/{id}")
	public ResponseEntity<String> updateStatusToApprove(@PathVariable Integer id) throws InsuranceException {
		String insurance = this.insuranceService.updateInsuranceStatusToApproved(id);
		return new ResponseEntity<String>(insurance, HttpStatus.OK);
	}
	
	@PutMapping("/insurance/reject/{id}")
	public ResponseEntity<String> updateStatusToReject(@PathVariable Integer id) throws InsuranceException {
		String insurance = this.insuranceService.updateInsuranceStatusToRejected(id);
		return new ResponseEntity<String>(insurance, HttpStatus.OK);
	}
}
