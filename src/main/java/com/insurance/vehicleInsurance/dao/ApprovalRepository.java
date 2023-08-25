package com.insurance.vehicleInsurance.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.insurance.vehicleInsurance.entity.Approval;

public interface ApprovalRepository extends JpaRepository<Approval, Integer>{

}
