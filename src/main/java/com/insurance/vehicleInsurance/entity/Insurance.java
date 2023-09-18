package com.insurance.vehicleInsurance.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Insurance {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer insuranceId;
	private Double insuranceAmount;
	private String insuranceNumber;
	private String insuranceDescription;
	private String insuranceType;
	private Integer endUserId;
	private String status;
	
	@OneToMany
	List<Payment> payments = new ArrayList<Payment>();
	@OneToMany
	List<Claim> claims = new ArrayList<Claim>();
	@OneToOne
	InsuranceRenewal insuranceRenewal;
	
	public Insurance() {
		super();
	}

	public Insurance(Double insuranceAmount, String insuranceNumber, String insuranceDescription,
			String insuranceType,Integer endUserId, String status) {
		super();
		this.insuranceAmount = insuranceAmount;
		this.insuranceNumber = insuranceNumber;
		this.insuranceDescription = insuranceDescription;
		this.insuranceType = insuranceType;
		this.endUserId = endUserId;
		this.status = status;
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

	public List<Payment> getPayments() {
		return payments;
	}

	public void setPayments(List<Payment> payments) {
		this.payments = payments;
	}

	public List<Claim> getClaims() {
		return claims;
	}

	public void setClaims(List<Claim> claims) {
		this.claims = claims;
	}

	public InsuranceRenewal getInsuranceRenewal() {
		return insuranceRenewal;
	}

	public void setInsuranceRenewal(InsuranceRenewal insuranceRenewal) {
		this.insuranceRenewal = insuranceRenewal;
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
