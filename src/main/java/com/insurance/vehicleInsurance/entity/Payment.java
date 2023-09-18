package com.insurance.vehicleInsurance.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Payment {
	
	@Id
	private Integer id;
	@JsonFormat(pattern="yyyy-MM-dd")
	private LocalDate date;
	private Double amount;
	private String description;
	private Integer endUserId;
	private Integer insuranceId;
	
	public Payment() {
		super();
	}

	public Payment(Integer id, LocalDate date, Double amount, String description, Integer endUserId, Integer insuranceId) {
		super();
		this.id = id;
		this.date = date;
		this.amount = amount;
		this.description = description;
		this.endUserId = endUserId;
		this.insuranceId = insuranceId;

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getEndUserId() {
		return endUserId;
	}

	public void setEndUserId(Integer endUserId) {
		this.endUserId = endUserId;
	}

	public Integer getInsuranceId() {
		return insuranceId;
	}

	public void setInsuranceId(Integer insuranceId) {
		this.insuranceId = insuranceId;
	}
}
