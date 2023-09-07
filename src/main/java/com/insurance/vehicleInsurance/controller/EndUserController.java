package com.insurance.vehicleInsurance.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.insurance.vehicleInsurance.dto.EndUserDto;
import com.insurance.vehicleInsurance.entity.EndUser;
import com.insurance.vehicleInsurance.exception.EndUserException;
import com.insurance.vehicleInsurance.service.EndUserService;
import com.insurance.vehicleInsurance.service.MailService;

@RestController
public class EndUserController {

	@Autowired
	MailService mailservice;

	@Autowired
	EndUserService UserService;

	@PostMapping("/addUser/")
	public EndUser addUser(@RequestBody EndUserDto user) throws EndUserException {
		String mail = user.getEmail();
		mailservice.sendMail(mail, "Successfully Registered", user.toString());
		return this.UserService.addUser(user);
	}

	@GetMapping("/findUser/{id}")
	public EndUser getUserById(@PathVariable String userName) throws EndUserException {
		return this.UserService.getUserById(userName);
	}

	@PutMapping("/updateUser/")
	public ResponseEntity<EndUser> replaceUser(@RequestBody EndUserDto updateuser) throws EndUserException {
		EndUser customer = this.UserService.updateUser(updateuser);
		return new ResponseEntity<EndUser>(customer, HttpStatus.OK);
	}

	@DeleteMapping("/deleteUser/{id}")
	public ResponseEntity<EndUser> deleteUserById(@PathVariable String userName) throws EndUserException {
		EndUser customer = this.UserService.deleteUserById(userName);
		return new ResponseEntity<EndUser>(customer, HttpStatus.OK);
	}

	@GetMapping("/getAllUsers/")
	@ResponseStatus(HttpStatus.OK)
	public List<EndUser> getAllUsers() {
		List<EndUser> userList = this.UserService.getAllUser();
		return userList;
	}

}
