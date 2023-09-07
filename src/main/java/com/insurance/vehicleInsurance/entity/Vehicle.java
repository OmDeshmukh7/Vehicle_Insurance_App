package com.insurance.vehicleInsurance.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Vehicle {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer vehicleId;
	private String vehicleType;
	private String vehicleRegNumber;
	private String vehicleName;
	private Integer customerId;
	
	@OneToOne
	private Insurance insurance;
	
	public Vehicle() {
		super();
	}

	public Vehicle(String vehicleType, String vehicleRegNumber, String vehicleName, Integer customerId) {
		super();
		this.vehicleType = vehicleType;
		this.vehicleRegNumber = vehicleRegNumber;
		this.vehicleName = vehicleName;
		this.customerId = customerId;
	}

	public Integer getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(Integer vehicleId) {
		this.vehicleId = vehicleId;
	}

	public String getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}

	public String getVehicleRegNumber() {
		return vehicleRegNumber;
	}

	public void setVehicleRegNumber(String vehicleRegNumber) {
		this.vehicleRegNumber = vehicleRegNumber;
	}
	public String getVehicleName() {
		return vehicleName;
	}

	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}

	public Insurance getInsurance() {
		return insurance;
	}

	public void setInsurance(Insurance insurance) {
		this.insurance = insurance;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
}
