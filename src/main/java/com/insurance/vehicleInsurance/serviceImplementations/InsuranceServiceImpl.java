package com.insurance.vehicleInsurance.serviceImplementations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insurance.vehicleInsurance.dao.EndUserRepository;
import com.insurance.vehicleInsurance.dao.InsuranceRepository;
import com.insurance.vehicleInsurance.dao.VehicleRepository;
import com.insurance.vehicleInsurance.dto.InsuranceDto;
import com.insurance.vehicleInsurance.entity.EndUser;
import com.insurance.vehicleInsurance.entity.Insurance;
import com.insurance.vehicleInsurance.entity.Vehicle;
import com.insurance.vehicleInsurance.exception.InsuranceException;
import com.insurance.vehicleInsurance.service.InsuranceService;

/* implements methodslike  creating insurance, updating insurance, searching insurance by insurance ID and getting a list of all purchased insurances. Also implements admin side methods like updating insurance status. */

@Service
public class InsuranceServiceImpl implements InsuranceService {

	@Autowired
	InsuranceRepository insuranceRepository;

	@Autowired
	EndUserRepository endUserRepository;

	@Autowired
	VehicleRepository vehicleRepository;

	@Override
	public Insurance addInsurance(InsuranceDto newInsurance) throws InsuranceException {

		Optional<EndUser> endUserOpt = this.endUserRepository.findById(newInsurance.getEndUserId());
		if (!endUserOpt.isPresent()) {
			throw new InsuranceException("No Customer is present with id: " + newInsurance.getEndUserId());
		}
		Optional<Insurance> insuranceOpt = this.insuranceRepository
				.findByInsuranceNumber(newInsurance.getInsuranceNumber());
		if (insuranceOpt.isPresent()) {
			throw new InsuranceException("Insurance already exist" + newInsurance.getInsuranceNumber());
		}
		Insurance insurance = new Insurance(newInsurance.getInsuranceAmount(), newInsurance.getInsuranceNumber(),
				newInsurance.getInsuranceDescription(), newInsurance.getInsuranceType(), newInsurance.getEndUserId(),
				newInsurance.getStatus());
		this.insuranceRepository.save(insurance);
		EndUser endUser = endUserOpt.get();
		List<Insurance> insurances = new ArrayList<Insurance>();
		endUser.setInsurances(insurances);
		this.endUserRepository.save(endUser);
		List<Vehicle> vehicleList = endUser.getVehicles();
		Vehicle vehicle = vehicleList.get(0);
		vehicle.setInsurance(insurance);
		this.vehicleRepository.save(vehicle);
		return insurance;
	}

	@Override
	public List<Insurance> getAllInsurance() {
		return this.insuranceRepository.findAll();
	}

	@Override
	public Insurance getInsuranceByInsuranceNumber(String insuranceNumber) throws InsuranceException {
		Optional<Insurance> insuranceOpt = this.insuranceRepository.findByInsuranceNumber(insuranceNumber);
		if (!insuranceOpt.isPresent()) {
			throw new InsuranceException("Insurance not found by given insurance number " + insuranceNumber);
		}
		Insurance insurance = insuranceOpt.get();
		return insurance;
	}

	@Override
	public String updateInsuranceStatusToApproved(Integer id) throws InsuranceException {
		Optional<Insurance> insuranceOpt = this.insuranceRepository.findById(id);
		if (!insuranceOpt.isPresent()) {
			throw new InsuranceException("No insurance is present by id: ");
		}
		Insurance insurance = insuranceOpt.get();
		insurance.setStatus("Approved");
		this.insuranceRepository.save(insurance);
		return "Approved";
	}

	@Override
	public String updateInsuranceStatusToRejected(Integer id) throws InsuranceException {
		Optional<Insurance> insuranceOpt = this.insuranceRepository.findById(id);
		if (!insuranceOpt.isPresent()) {
			throw new InsuranceException("No insurance is present by id: ");
		}
		Insurance insurance = insuranceOpt.get();
		insurance.setStatus("Rejected");
		this.insuranceRepository.save(insurance);
		return "Rejected";
	}

}
