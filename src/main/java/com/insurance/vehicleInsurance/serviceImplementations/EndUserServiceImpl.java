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
	
	/* Implements methods like adding a user, updating user details, deleting users, getting a list of all users and finding users by user ID */
	
	@Override
	public EndUser addUser(EndUserDto nc) throws EndUserException {
		Optional<EndUser> UserOpt = this.UserRepository.findByName(nc.getUserName());
		if(UserOpt.isPresent()) {
			throw new EndUserException("User already exist name: "+nc.getUserName());
		}

		EndUser User = new EndUser(nc.getName(),nc.getMobile(),nc.getEmail(),nc.getAddress(),nc.getUserName(),nc.getPassword(),nc.getRole());		
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
		EndUser User = new EndUser(newUser.getName(),newUser.getMobile(),newUser.getEmail(),newUser.getAddress(),newUser.getUserName(),newUser.getPassword(),newUser.getRole());	
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

	@Override
	public String getUserRole(String userName) throws EndUserException {
		Optional<EndUser> userOpt = this.UserRepository.findByUserName(userName);
		if(!userOpt.isPresent()) {
			System.out.println("nahi run hot");
		}
		EndUser endUser = userOpt.get();
		String role = endUser.getRole(); 
		return role;
	}

}
