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
	
	public Payment() {
		super();
	}

	public Payment(Integer id, LocalDate date, Double amount, String description) {
		super();
		this.id = id;
		this.date = date;
		this.amount = amount;
		this.description = description;

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
}
