package com.insurance.vehicleInsurance.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Documents {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer documentId;
	private String documentDescription;
	private String documentType;
	private String documentNumber;
	private Integer endUserId;

	public Documents() {
		super();
	}

	public Documents(String documentDescription, String documentType, String documentNumber, Integer endUserId) {
		super();
		this.documentDescription = documentDescription;
		this.documentType = documentType;
		this.documentNumber = documentNumber;
		this.endUserId = endUserId;
	}

	public Integer getDocumentId() {
		return documentId;
	}

	public void setDocumentId(Integer documentId) {
		this.documentId = documentId;
	}

	public String getDocumentDescription() {
		return documentDescription;
	}

	public void setDocumentDescription(String documentDescription) {
		this.documentDescription = documentDescription;
	}

	public String getDocumentType() {
		return documentType;
	}

	public void setDocumentType(String documentType) {
		this.documentType = documentType;
	}

	public String getDocumentNumber() {
		return documentNumber;
	}

	public void setDocumentNumber(String documentNumber) {
		this.documentNumber = documentNumber;
	}

	public Integer getEndUserId() {
		return endUserId;
	}

	public void setEndUserId(Integer customerId) {
		this.endUserId = customerId;
	}
}
