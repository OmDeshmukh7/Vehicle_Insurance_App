package com.insurance.vehicleInsurance.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.insurance.vehicleInsurance.dto.CustomerDto;
import com.insurance.vehicleInsurance.entity.Customer;
import com.insurance.vehicleInsurance.exception.CustomerException;
import com.insurance.vehicleInsurance.service.CustomerService;


@RestController
public class CustomerController {
	

	
	@Autowired
	CustomerService customerService;
	
	@PostMapping("/customer/")
	public Customer addCustomer(@RequestBody CustomerDto customer) throws CustomerException {
			return this.customerService.addCustomer(customer);
	}
	
	@GetMapping("/customer/{id}")
	public Customer getCustomerById(@PathVariable Integer id) throws CustomerException {
		return this.customerService.getCustomerById(id);
	}
	
	@PutMapping("/customer/")
	public ResponseEntity<Customer> replaceCustomer(@RequestBody Customer updateCustomer) throws CustomerException{
		Customer customer = this.customerService.updateCustomer(updateCustomer);
		return new ResponseEntity<Customer>(customer,HttpStatus.OK);
	}
	
	@DeleteMapping("/customer/{id}")
	public ResponseEntity<Customer> deleteCustomerById(@PathVariable Integer id) throws CustomerException{
		Customer customer = this.customerService.deleteCustomerById(id);
		return new ResponseEntity<Customer>(customer, HttpStatus.OK);
	}
	
	@GetMapping("/customers/")
	@ResponseStatus(HttpStatus.OK)
	public List<Customer> getAllCustomers(){
		List<Customer> customerList = this.customerService.getAllCustomer();
		return customerList;
	}
	
}
