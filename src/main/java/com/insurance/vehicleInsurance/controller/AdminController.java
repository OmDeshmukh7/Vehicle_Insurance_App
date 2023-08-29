package com.insurance.vehicleInsurance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.insurance.vehicleInsurance.entity.Admin;
import com.insurance.vehicleInsurance.exception.AdminException;
import com.insurance.vehicleInsurance.service.AdminService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
public class AdminController {

	@Autowired
	AdminService adminService;
	
	@PostMapping("/admin/")
	public Admin addAdmin(@RequestBody Admin admin)throws AdminException{
		try {
			return this.adminService.addAdmin(admin);
		}catch(AdminException e) {
			throw e;
		}
	}
}
