package com.insurance.vehicleInsurance.dto;


public class CustomerDto {

	
	private String customerName;
	private String customerMobile;
	private String customerEmail;
	private String customerAddress;
	private String customerUserName;
	private String customerPassword;
	
	public CustomerDto() {
		super();
	}
	
	public CustomerDto(String customerName, String customerMobile, String customerEmail,
			String customerAddress, String customerUserName, String customerPassword) {
		super();
		this.customerName = customerName;
		this.customerMobile = customerMobile;
		this.customerEmail = customerEmail;
		this.customerAddress = customerAddress;
		this.customerUserName = customerUserName;
		this.customerPassword = customerPassword;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerMobile() {
		return customerMobile;
	}
	public void setCustomerMobile(String customerMobile) {
		this.customerMobile = customerMobile;
	}
	public String getCustomerEmail() {
		return customerEmail;
	}
	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}
	public String getCustomerAddress() {
		return customerAddress;
	}
	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}
	public String getCustomerUserName() {
		return customerUserName;
	}
	public void setCustomerUserName(String customerUserName) {
		this.customerUserName = customerUserName;
	}
	public String getCustomerPassword() {
		return customerPassword;
	}
	public void setCustomerPassword(String customerPassword) {
		this.customerPassword = customerPassword;
	}
	
	
}
