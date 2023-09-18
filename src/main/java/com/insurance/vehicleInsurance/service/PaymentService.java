package com.insurance.vehicleInsurance.service;

import java.util.List;
import com.insurance.vehicleInsurance.entity.Payment;
import com.insurance.vehicleInsurance.exception.PaymentException;

public interface PaymentService {

	Payment createPaymentByInsuranceId(Payment newPayment)throws PaymentException;

	List<Payment> getPaymentByInsuranceId(Integer insuranceId) throws PaymentException;
}
