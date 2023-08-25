package com.insurance.vehicleInsurance.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Claim {

	@Id
	private Integer claimId;
	private String claimType;
	private LocalDate claimDate;
	private String claimDescription;
	private String claimStatus;
	
	public Claim() {
		super();
	}

	public Claim(Integer claimId, String claimType, LocalDate claimDate, String claimDescription, String claimStatus) {
		super();
		this.claimId = claimId;
		this.claimType = claimType;
		this.claimDate = claimDate;
		this.claimDescription = claimDescription;
		this.claimStatus = claimStatus;
	}

	public Integer getClaimId() {
		return claimId;
	}

	public void setClaimId(Integer claimId) {
		this.claimId = claimId;
	}

	public String getClaimType() {
		return claimType;
	}

	public void setClaimType(String claimType) {
		this.claimType = claimType;
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
}
