package com.insurance.vehicleInsurance.dto;

import javax.persistence.Id;

public class VehicleDto {

	@Id
	private Integer vehicleId;
	private String vehicleType;
	private String vehicleRegNumber;
	private String vehicleName;
	
	public VehicleDto() {
		super();
	}

	public VehicleDto(Integer vehicleId, String vehicleType, String vehicleRegNumber, String vehicleName) {
		super();
		this.vehicleId = vehicleId;
		this.vehicleType = vehicleType;
		this.vehicleRegNumber = vehicleRegNumber;
		this.vehicleName = vehicleName;
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
	
}
