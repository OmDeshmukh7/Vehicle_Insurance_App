package com.insurance.vehicleInsurance.service;

import java.util.List;

import com.insurance.vehicleInsurance.entity.Admin;
import com.insurance.vehicleInsurance.exception.AdminException;

public interface AdminService {
	
	Admin addAdmin (Admin newAdmin)throws AdminException;
	
	Admin updateAdmin(Admin newAdmin)throws AdminException;
	
	Admin deleteAdminById (Integer id)throws AdminException;
	
	List<Admin>getAllAdmins();

}
