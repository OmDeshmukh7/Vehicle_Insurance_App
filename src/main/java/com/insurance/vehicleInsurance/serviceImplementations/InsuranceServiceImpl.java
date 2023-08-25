package com.insurance.vehicleInsurance.serviceImplementations;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insurance.vehicleInsurance.dao.InsuranceRepository;
import com.insurance.vehicleInsurance.entity.Insurance;
import com.insurance.vehicleInsurance.exception.InsuranceException;
import com.insurance.vehicleInsurance.service.InsuranceService;

@Service
public class InsuranceServiceImpl implements InsuranceService{

	@Autowired
	InsuranceRepository insuranceRepository;
	
	@Override
	public Insurance addInsurance(Insurance newInsurance) throws InsuranceException {
		Optional<Insurance> insuranceOpt = this.insuranceRepository.findById(newInsurance.getInsuranceId());
		if(insuranceOpt.isPresent()) {
			throw new InsuranceException("Insurance already exist"+newInsurance.getInsuranceNumber());
		}
		return this.insuranceRepository.save(newInsurance);
	}

	@Override
	public Insurance getInsuranceById(Integer id) throws InsuranceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Insurance updateinsurance(Insurance newInsurance) throws InsuranceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Insurance deleteInsuranceById(Integer id) throws InsuranceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Insurance> getAllInsurance() {
		// TODO Auto-generated method stub
		return null;
	}

}
