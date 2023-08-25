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
	
	@OneToMany
	List<Payment> payments = new ArrayList<Payment>();
	@OneToMany
	List<Claim> claims = new ArrayList<Claim>();
	@OneToOne
	InsuranceRenewal insuranceRenewal;
	
	public Insurance() {
		super();
	}

	public Insurance(Integer insuranceId, Double insuranceAmount, String insuranceNumber, String insuranceDescription,
			String insuranceType, List<Payment> payments, List<Claim> claims,
			InsuranceRenewal insuranceRenewal) {
		super();
		this.insuranceId = insuranceId;
		this.insuranceAmount = insuranceAmount;
		this.insuranceNumber = insuranceNumber;
		this.insuranceDescription = insuranceDescription;
		this.insuranceType = insuranceType;
		this.payments = payments;
		this.claims = claims;
		this.insuranceRenewal = insuranceRenewal;
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
}
