package com.insurance.vehicleInsurance.dto;


public class EndUserDto {

	private String name;
	private String mobile;
	private String email;
	private String address;
	private String userName;
	private String password;
	private String role = "User";

	
	public EndUserDto() {
		super();
	}


	public EndUserDto(String name, String mobile, String email, String address, String userName,
			String password, String role) {
		super();
		this.name = name;
		this.mobile = mobile;
		this.email = email;
		this.address = address;
		this.userName = userName;
		this.password = password;
		this.role = role;
	}
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getMobile() {
		return mobile;
	}


	public void setMobile(String mobile) {
		this.mobile = mobile;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
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


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = "User";
	}
	
}
