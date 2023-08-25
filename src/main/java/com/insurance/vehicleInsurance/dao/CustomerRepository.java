package com.insurance.vehicleInsurance.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.insurance.vehicleInsurance.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
