package com.insurance.vehicleInsurance.dto;

import javax.persistence.Id;

public class InsuranceDto {

	@Id
	private Integer insuranceId;
	private Double insuranceAmount;
	private String insuranceNumber;
	private String insuranceDescription;
	private String insuranceType;
	private Integer endUserId;
	private String status;
	
	public InsuranceDto() {
		super();
	}

	public InsuranceDto( Double insuranceAmount, String insuranceNumber,
			String insuranceDescription, String insuranceType,Integer endUserId,String status) {
		super();
		this.insuranceAmount = insuranceAmount;
		this.insuranceNumber = insuranceNumber;
		this.insuranceDescription = insuranceDescription;
		this.insuranceType = insuranceType;
		this.endUserId = endUserId;
		this.status= status;
	}

	public Integer getInsuranceId() {
		return insuranceId;
	}

	public void setInsuranceId(Integer insuranceId) {
		this.insuranceId = insuranceId;
	}

	public Double getInsuranceAmount() {
		return insuranceAmount;
	}

	public void setInsuranceAmount(Double insuranceAmount) {
		this.insuranceAmount = insuranceAmount;
	}

	public String getInsuranceNumber() {
		return insuranceNumber;
	}

	public void setInsuranceNumber(String insuranceNumber) {
		this.insuranceNumber = insuranceNumber;
	}

	public String getInsuranceDescription() {
		return insuranceDescription;
	}

	public void setInsuranceDescription(String insuranceDescription) {
		this.insuranceDescription = insuranceDescription;
	}

	public String getInsuranceType() {
		return insuranceType;
	}

	public void setInsuranceType(String insuranceType) {
		this.insuranceType = insuranceType;
	}

	public Integer getEndUserId() {
		return endUserId;
	}

	public void setEndUserId(Integer endUserId) {
		this.endUserId = endUserId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
}
