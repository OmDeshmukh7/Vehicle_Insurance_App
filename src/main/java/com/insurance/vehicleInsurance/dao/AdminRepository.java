package com.insurance.vehicleInsurance.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.insurance.vehicleInsurance.entity.Admin;

public interface AdminRepository extends JpaRepository<Admin, Integer>{

}
