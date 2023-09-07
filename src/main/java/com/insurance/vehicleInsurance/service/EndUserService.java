package com.insurance.vehicleInsurance.service;

import java.util.List;

import com.insurance.vehicleInsurance.dto.EndUserDto;
import com.insurance.vehicleInsurance.entity.EndUser;
import com.insurance.vehicleInsurance.exception.EndUserException;

public interface EndUserService {

	EndUser addUser(EndUserDto newUser) throws EndUserException;

	EndUser getUserById(String userName) throws EndUserException;

	EndUser updateUser(EndUserDto newUser) throws EndUserException;

	EndUser deleteUserById(String userName) throws EndUserException;

	List<EndUser> getAllUser();

}
