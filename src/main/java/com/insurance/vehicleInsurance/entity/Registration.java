package com.insurance.vehicleInsurance.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;


@Entity
public class Registration {
	
	@Id
	private Integer id;
	private String name;
	private String phone;
	private String email;
	private String description;
	private String userName;
	private String password;

	@OneToOne
	EndUser customer;
	
	public Registration() {
		super();
	}

	public Registration(Integer id, String name, String phone,String email, String description, String userName, String password,
			EndUser customer) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.description = description;
		this.userName = userName;
		this.password = password;
		this.customer = customer;
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

	public EndUser getCustomer() {
		return customer;
	}

	public void setCustomer(EndUser customer) {
		this.customer = customer;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
