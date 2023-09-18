package com.insurance.vehicleInsurance.controller;

import javax.security.auth.login.LoginException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.insurance.vehicleInsurance.entity.Login;
import com.insurance.vehicleInsurance.service.LoginService;

@RestController
@CrossOrigin(origins="http://localhost:4200/")
public class LoginController {

	@Autowired
	LoginService loginService;
	
	@PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Login login) {
        try {
            Login user = loginService.login(login.getUserName(), login.getPassword());
            return ResponseEntity.ok(login);
        } catch (LoginException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
        }
    }
}
