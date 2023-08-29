package com.insurance.vehicleInsurance.serviceImplementations;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insurance.vehicleInsurance.dao.AdminRepository;
import com.insurance.vehicleInsurance.dao.ApprovalRepository;
import com.insurance.vehicleInsurance.entity.Admin;
import com.insurance.vehicleInsurance.entity.Approval;
import com.insurance.vehicleInsurance.exception.AdminException;
import com.insurance.vehicleInsurance.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService{

	@Autowired
	AdminRepository adminRepository;
	
	@Autowired
	ApprovalRepository approvalRepository;
	
	
	@Override
	public Admin addAdmin(Admin newAdmin) throws AdminException {
		Optional<Admin> adminOpt = this.adminRepository.findById(newAdmin.getAdminId());
		if(adminOpt.isPresent()) {
			throw new AdminException("Admin already exist"+newAdmin.getAdminName());
		}List<Approval> approvals = newAdmin.getApprovals();
		if(approvals != null) {
			approvals = this.approvalRepository.saveAll(approvals);
		}newAdmin.setApprovals(approvals);
		return this.adminRepository.save(newAdmin);
	}

	@Override
	public Admin updateAdmin(Admin newAdmin) throws AdminException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Admin deleteAdminById(Integer id) throws AdminException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Admin> getAllAdmins() {
		// TODO Auto-generated method stub
		return null;
	}

}
