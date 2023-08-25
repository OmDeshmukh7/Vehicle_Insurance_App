package com.insurance.vehicleInsurance.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Approval {

	@Id
	private Integer approvalId;
	private String approvalType;
	private String approvalStatus;
	@OneToOne
	private Insurance insurance;
	@OneToOne
	private Claim claim;
	@OneToOne
	private Registration registration;
	
	public Approval() {
		super();
	}
	
	public Approval(Integer approvalId, String approvalType, String approvalStatus, Insurance insurance, Claim claim,
			Registration registration) {
		super();
		this.approvalId = approvalId;
		this.approvalType = approvalType;
		this.approvalStatus = approvalStatus;
		this.insurance = insurance;
		this.claim = claim;
		this.registration = registration;
	}

	public Integer getApprovalId() {
		return approvalId;
	}

	public void setApprovalId(Integer approvalId) {
		this.approvalId = approvalId;
	}

	public String getApprovalType() {
		return approvalType;
	}

	public void setApprovalType(String approvalType) {
		this.approvalType = approvalType;
	}

	public String getApprovalStatus() {
		return approvalStatus;
	}

	public void setApprovalStatus(String approvalStatus) {
		this.approvalStatus = approvalStatus;
	}

	public Insurance getInsurance() {
		return insurance;
	}

	public void setInsurance(Insurance insurance) {
		this.insurance = insurance;
	}

	public Claim getClaim() {
		return claim;
	}

	public void setClaim(Claim claim) {
		this.claim = claim;
	}

	public Registration getRegistration() {
		return registration;
	}

	public void setRegistration(Registration registration) {
		this.registration = registration;
	}
	
}
