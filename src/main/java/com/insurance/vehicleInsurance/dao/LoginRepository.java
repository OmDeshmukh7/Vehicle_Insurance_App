package com.insurance.vehicleInsurance.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.insurance.vehicleInsurance.entity.Login;

public interface LoginRepository extends JpaRepository<Login, Integer>{

}
