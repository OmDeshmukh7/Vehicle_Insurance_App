package com.insurance.vehicleInsurance.service;

import java.util.List;

import com.insurance.vehicleInsurance.dto.CustomerDto;
import com.insurance.vehicleInsurance.entity.Customer;
import com.insurance.vehicleInsurance.exception.CustomerException;

public interface CustomerService {

	Customer addCustomer(CustomerDto newCustomer) throws CustomerException;

	Customer getCustomerById(Integer id) throws CustomerException;

	Customer updateCustomer(CustomerDto newCustomer) throws CustomerException;

	Customer deleteCustomerById(Integer id) throws CustomerException;

	List<Customer> getAllCustomer();

}
