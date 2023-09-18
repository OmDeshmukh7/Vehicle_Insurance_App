package com.insurance.vehicleInsurance.serviceImplementations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insurance.vehicleInsurance.dao.EndUserRepository;
import com.insurance.vehicleInsurance.dao.InsuranceRepository;
import com.insurance.vehicleInsurance.dao.PaymentRepository;
import com.insurance.vehicleInsurance.entity.EndUser;
import com.insurance.vehicleInsurance.entity.Insurance;
import com.insurance.vehicleInsurance.entity.Payment;
import com.insurance.vehicleInsurance.exception.PaymentException;
import com.insurance.vehicleInsurance.service.PaymentService;

/* implemenmts methods like adding a payment for a particular insurance, and get a list of payments for the insuranceID. also checks if the endUser and insurance exists for that user before payment. */

@Service
public class PaymentServiceImpl implements PaymentService {

	@Autowired
	EndUserRepository endUserRepository;

	@Autowired
	PaymentRepository paymentRepository;

	@Autowired
	InsuranceRepository insuranceRepository;
	
	@Override
	public Payment createPaymentByInsuranceId(Payment newPayment) throws PaymentException {
		Optional<Insurance> insuranceOpt = this.insuranceRepository.findById(newPayment.getInsuranceId());
		if (!insuranceOpt.isPresent()) {
			throw new PaymentException("Insurance policy not found by id: " + newPayment.getInsuranceId());
		}
		Optional<EndUser> endUserOpt = this.endUserRepository.findById(newPayment.getEndUserId());
		if (!endUserOpt.isPresent()) {
			throw new PaymentException("EndUser not found by id: " + newPayment.getEndUserId());
		}
		this.paymentRepository.save(newPayment);
		List<Payment> payments = new ArrayList<Payment>();
		payments.add(newPayment);
		Insurance insurance = insuranceOpt.get();
		EndUser endUser = endUserOpt.get();
		insurance.setPayments(payments);
		endUser.setPayments(payments);
		this.endUserRepository.save(endUser);
		this.insuranceRepository.save(insurance);
		return newPayment;
	}

	@Override
	public List<Payment> getPaymentByInsuranceId(Integer insuranceId) throws PaymentException {
		Optional<Insurance> insuranceOpt = this.insuranceRepository.findById(insuranceId);
		if (!insuranceOpt.isPresent()) {
			throw new PaymentException("Insurance policy not found by id: " + insuranceId);
		}
		List<Payment> payments = paymentRepository.findByInsuranceId(insuranceId);
		return payments;
	}

}
