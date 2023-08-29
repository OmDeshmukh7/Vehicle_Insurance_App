package com.insurance.vehicleInsurance.serviceImplementations;

import java.util.List;

import org.springframework.stereotype.Service;

import com.insurance.vehicleInsurance.entity.Payment;
import com.insurance.vehicleInsurance.exception.PaymentException;
import com.insurance.vehicleInsurance.service.PaymentService;

@Service
public class PaymentServiceImpl implements PaymentService{

	@Override
	public Payment addPayment(Payment newPayment) throws PaymentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Payment getPaymentById(Integer id) throws PaymentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Payment deletePaymentById(Integer id) throws PaymentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Payment> getAllPayments() {
		// TODO Auto-generated method stub
		return null;
	}

}
