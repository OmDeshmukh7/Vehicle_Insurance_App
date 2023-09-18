package com.insurance.vehicleInsurance.service;

import javax.security.auth.login.LoginException;

import com.insurance.vehicleInsurance.entity.Login;

public interface LoginService {
	
	Login login(String userName, String password) throws LoginException;
	
}
