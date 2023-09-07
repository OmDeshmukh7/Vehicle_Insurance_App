package com.insurance.vehicleInsurance.serviceImplementations;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.insurance.vehicleInsurance.dao.EndUserRepository;
import com.insurance.vehicleInsurance.dto.EndUserDto;
import com.insurance.vehicleInsurance.entity.EndUser;
import com.insurance.vehicleInsurance.exception.EndUserException;
import com.insurance.vehicleInsurance.service.EndUserService;

@Service
public class EndUserServiceImpl implements EndUserService{

	@Autowired
	EndUserRepository UserRepository;
	
	@Override
	public EndUser addUser(EndUserDto nc) throws EndUserException {
		Optional<EndUser> UserOpt = this.UserRepository.findByName(nc.getUserName());
		if(UserOpt.isPresent()) {
			throw new EndUserException("User already exist name: "+nc.getUserName());
		}
//		List<Vehicle> vehicles = User.getVehicles();
//		if(vehicles != null) {
//			vehicles = this.vehicleRepository.saveAll(vehicles);
//		}User.setVehicles(vehicles);
//		Documents documents = User.getDocuments();
//		if(documents != null) {
//			documents = this.documentRepository.save(documents);
//		}User.setDocuments(documents);
//		Registration registration = User.getRegistration();
//		if(registration != null) {
//			registration = this.registrationRepository.save(registration);
//		}User.setRegistration(registration);
//		List<Insurance> insurances= User.getInsurances();
//		if(insurances != null) {
//			insurances=this.insuranceRepository.saveAll(insurances);
//		}User.setInsurances(insurances);
		EndUser User = new EndUser(nc.getName(),nc.getMobile(),nc.getEmail(),nc.getAddress(),nc.getUserName(),nc.getPassword());		
		return this.UserRepository.save(User);
	}

	@Override
	public EndUser getUserById(String userName) throws EndUserException {
		Optional<EndUser> UserOpt = this.UserRepository.findByName(userName);
		if(!UserOpt.isPresent()) {
			throw new EndUserException("User not found for "+userName);
		}
		return UserOpt.get();
	}

	@Override
	public EndUser updateUser(EndUserDto newUser) throws EndUserException {
		if(newUser==null) {
			throw new EndUserException("Please enter valid values.");
		}
		EndUser User = new EndUser(newUser.getName(),newUser.getMobile(),newUser.getEmail(),newUser.getAddress(),newUser.getUserName(),newUser.getPassword());	
		return this.UserRepository.save(User);
	}

	@Override
	public EndUser deleteUserById(String userName) throws EndUserException {
		Optional<EndUser> UserOpt = this.UserRepository.findByName(userName);
		if(!UserOpt.isPresent()) {
			throw new EndUserException("User not found to delete "+userName);
		}
		EndUser User = UserOpt.get();
		this.UserRepository.delete(User);
		return User;
	}

	@Override
	public List<EndUser> getAllUser() {
		return this.UserRepository.findAll();
	}

}
