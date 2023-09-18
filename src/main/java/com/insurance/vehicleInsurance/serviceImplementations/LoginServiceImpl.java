package com.insurance.vehicleInsurance.serviceImplementations;

import java.util.Optional;

import javax.security.auth.login.LoginException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insurance.vehicleInsurance.dao.EndUserRepository;
import com.insurance.vehicleInsurance.dao.LoginRepository;
import com.insurance.vehicleInsurance.entity.EndUser;
import com.insurance.vehicleInsurance.entity.Login;
import com.insurance.vehicleInsurance.service.LoginService;

/* implements the login method; checks if user is registered and entered details are valid */

@Service
public class LoginServiceImpl implements LoginService{

	@Autowired
	LoginRepository loginRepository;
	
	@Autowired
	EndUserRepository endUserRepository;

	@Override
	public Login login(String userName, String password) throws LoginException {
		Optional<EndUser> userOptional = endUserRepository.findByUserName(userName);
        if (userOptional.isPresent()) {
            EndUser user = userOptional.get();
            if (user.getPassword().equals(password)) {
                Login login = new Login();
                login.setPassword(password);
                login.setUserName(userName);
            	return login;
            }
        }
        throw new LoginException("Invalid username or password");
    
	}

}
