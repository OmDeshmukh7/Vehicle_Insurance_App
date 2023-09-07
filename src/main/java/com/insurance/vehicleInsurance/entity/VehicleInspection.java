package com.insurance.vehicleInsurance.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class VehicleInspection {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer inspectionId;
	private String report;
	private LocalDate inspectionDate;
	private String inspectionStatus;
	private Integer vehicleId;
	
	public VehicleInspection() {
		super();
	}
	
	public VehicleInspection(String report, LocalDate inspectionDate, String inspectionStatus, Integer vehicleId) {
		super();
		this.report = report;
		this.inspectionDate = inspectionDate;
		this.inspectionStatus = inspectionStatus;
		this.vehicleId = vehicleId;
	}

	public Integer getInspectionId() {
		return inspectionId;
	}

	public void setInspectionId(Integer inspectionId) {
		this.inspectionId = inspectionId;
	}

	public String getReport() {
		return report;
	}

	public void setReport(String report) {
		this.report = report;
	}

	public LocalDate getInspectionDate() {
		return inspectionDate;
	}

	public void setInspectionDate(LocalDate inspectionDate) {
		this.inspectionDate = inspectionDate;
	}

	public String getInspectionStatus() {
		return inspectionStatus;
	}

	public void setInspectionStatus(String inspectionStatus) {
		this.inspectionStatus = inspectionStatus;
	}

	public Integer getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(Integer vehicleId) {
		this.vehicleId = vehicleId;
	}
}
