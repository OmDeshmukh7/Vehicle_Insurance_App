package com.insurance.vehicleInsurance.dto;

import javax.persistence.Id;

public class RegistrationDto {

	@Id
	private Integer id;
	private String name;
	private String phone;
	private String description;
	private String userName;
	private String password;
	
	public RegistrationDto() {
		super();
	}

	public RegistrationDto(Integer id, String name, String phone, String description, String userName,
			String password) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.description = description;
		this.userName = userName;
		this.password = password;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
