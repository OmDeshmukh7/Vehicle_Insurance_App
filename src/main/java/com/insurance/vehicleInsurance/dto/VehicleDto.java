package com.insurance.vehicleInsurance.dto;

public class VehicleDto {

	private String vehicleType;
	private String vehicleRegNumber;
	private String vehicleName;
	private Integer endUserId;
	
	public VehicleDto() {
		super();
	}

	public VehicleDto(String vehicleType, String vehicleRegNumber, String vehicleName, Integer customerId) {
		super();
		this.vehicleType = vehicleType;
		this.vehicleRegNumber = vehicleRegNumber;
		this.vehicleName = vehicleName;
		this.endUserId = customerId;
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

	public Integer getEndUserId() {
		return endUserId;
	}

	public void setEndUserId(Integer customerId) {
		this.endUserId = customerId;
	}
}
