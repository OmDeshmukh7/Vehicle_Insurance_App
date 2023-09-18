package com.insurance.vehicleInsurance.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Claim {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer claimId;
	private String claimAmount;
	private LocalDate claimDate;
	private String claimDescription;
	private String claimStatus;
	private Integer insuranceId;
	private Integer endUserId;


	public Claim(String claimAmount, LocalDate claimDate, String claimDescription, String claimStatus,
			Integer insuranceId, Integer endUserId) {
		super();
		
		this.claimAmount = claimAmount;
		this.claimDate = claimDate;
		this.claimDescription = claimDescription;
		this.claimStatus = claimStatus;
		this.insuranceId = insuranceId;
		this.endUserId = endUserId;
	}

	public Claim() {
		super();
	}


	public Integer getClaimId() {
		return claimId;
	}

	public void setClaimId(Integer claimId) {
		this.claimId = claimId;
	}

	public String getClaimAmount() {
		return claimAmount;
	}

	public void setClaimAmount(String claimAmount) {
		this.claimAmount = claimAmount;
	}

	public LocalDate getClaimDate() {
		return claimDate;
	}

	public void setClaimDate(LocalDate claimDate) {
		this.claimDate = claimDate;
	}

	public String getClaimDescription() {
		return claimDescription;
	}

	public void setClaimDescription(String claimDescription) {
		this.claimDescription = claimDescription;
	}

	public String getClaimStatus() {
		return claimStatus;
	}

	public void setClaimStatus(String claimStatus) {
		this.claimStatus = claimStatus;
	}

	public Integer getInsuranceId() {
		return insuranceId;
	}

	public void setInsuranceId(Integer insuranceId) {
		this.insuranceId = insuranceId;
	}

	public Integer getEndUserId() {
		return endUserId;
	}

	public void setEndUserId(Integer endUserId) {
		this.endUserId = endUserId;
	}

}
