package com.insurance.vehicleInsurance.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class VehicleInspection {

	@Id
	private Integer inspectionId;
	private String report;
	private LocalDate inspectionDate;
	private String inspectionStatus;
	
	public VehicleInspection() {
		super();
	}
	
	public VehicleInspection(Integer inspectionId, String report, LocalDate inspectionDate, String inspectionStatus) {
		super();
		this.inspectionId = inspectionId;
		this.report = report;
		this.inspectionDate = inspectionDate;
		this.inspectionStatus = inspectionStatus;
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
}
