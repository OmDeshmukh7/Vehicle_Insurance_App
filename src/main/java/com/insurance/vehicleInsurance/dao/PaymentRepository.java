package com.insurance.vehicleInsurance.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.insurance.vehicleInsurance.entity.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Integer>{

}
