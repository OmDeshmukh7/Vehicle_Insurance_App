package com.insurance.vehicleInsurance.entity;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Documents {

	@Id
	private Integer documentId;
	private String documentDescription;
	private String documentType;
	private String documentNumber;

	public Documents() {
		super();
	}

	public Documents(Integer documentId, String documentDescription, String documentType, String documentNumber) {
		super();
		this.documentId = documentId;
		this.documentDescription = documentDescription;
		this.documentType = documentType;
		this.documentNumber = documentNumber;
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
}
