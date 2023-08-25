package com.insurance.vehicleInsurance.service;

import java.util.List;
import com.insurance.vehicleInsurance.entity.Payment;
import com.insurance.vehicleInsurance.exception.PaymentException;

public interface PaymentService {
	
	Payment addPayment(Payment newPayment)throws PaymentException;
	
	Payment getPaymentById(Integer id)throws PaymentException;
	
	Payment deletePaymentById(Integer id)throws PaymentException;
	
	List<Payment>getAllPayments();
}
