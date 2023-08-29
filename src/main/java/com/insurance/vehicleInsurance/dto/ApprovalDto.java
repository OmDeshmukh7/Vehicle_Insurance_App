package com.insurance.vehicleInsurance.dto;

import javax.persistence.Id;

public class ApprovalDto {

	@Id
	private Integer approvalId;
	private String approvalType;
	private String approvalStatus;
	
	public ApprovalDto() {
		super();
	}

	public ApprovalDto(Integer approvalId, String approvalType, String approvalStatus) {
		super();
		this.approvalId = approvalId;
		this.approvalType = approvalType;
		this.approvalStatus = approvalStatus;
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
}
