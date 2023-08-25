package com.insurance.vehicleInsurance.service;

import java.util.List;

import com.insurance.vehicleInsurance.entity.Approval;
import com.insurance.vehicleInsurance.exception.ApprovalException;

public interface ApprovalService {
	
	Approval addApproval(Approval newApproval)throws ApprovalException;
	
	Approval getApprovalById(Integer id)throws ApprovalException;
	
	Approval updateApproval(Approval newApproval)throws ApprovalException;
	
	Approval deleteApproval(Integer id)throws ApprovalException;
	
	List<Approval>getAllApprovals();

}
