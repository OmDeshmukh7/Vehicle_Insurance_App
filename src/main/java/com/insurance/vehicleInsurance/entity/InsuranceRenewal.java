package com.insurance.vehicleInsurance.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class InsuranceRenewal {

	@Id
	private Integer insuranceId;
	private LocalDate insuranceDate;
	private Double insuranceAmount;
	private String insuranceType;
	private String insuranceDescription;
	private String insuranceRenewalStatus;
	
	public InsuranceRenewal() {
		super();
	}

	public InsuranceRenewal(Integer insuranceId, LocalDate insuranceDate, Double insuranceAmount, String insuranceType,
			String insuranceDescription, String insuranceRenewalStatus) {
		super();
		this.insuranceId = insuranceId;
		this.insuranceDate = insuranceDate;
		this.insuranceAmount = insuranceAmount;
		this.insuranceType = insuranceType;
		this.insuranceDescription = insuranceDescription;
		this.insuranceRenewalStatus = insuranceRenewalStatus;
	}

	public Integer getInsuranceId() {
		return insuranceId;
	}

	public void setInsuranceId(Integer insuranceId) {
		this.insuranceId = insuranceId;
	}

	public LocalDate getInsuranceDate() {
		return insuranceDate;
	}

	public void setInsuranceDate(LocalDate insuranceDate) {
		this.insuranceDate = insuranceDate;
	}

	public Double getInsuranceAmount() {
		return insuranceAmount;
	}

	public void setInsuranceAmount(Double insuranceAmount) {
		this.insuranceAmount = insuranceAmount;
	}

	public String getInsuranceType() {
		return insuranceType;
	}

	public void setInsuranceType(String insuranceType) {
		this.insuranceType = insuranceType;
	}

	public String getInsuranceDescription() {
		return insuranceDescription;
	}

	public void setInsuranceDescription(String insuranceDescription) {
		this.insuranceDescription = insuranceDescription;
	}

	public String getInsuranceRenewalStatus() {
		return insuranceRenewalStatus;
	}

	public void setInsuranceRenewalStatus(String insuranceRenewalStatus) {
		this.insuranceRenewalStatus = insuranceRenewalStatus;
	}
}
