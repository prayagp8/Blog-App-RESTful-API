package com.blog.service;

import org.springframework.stereotype.Service;

import com.blog.exception.LoginException;
import com.blog.modal.CurrentUserSession;
import com.blog.modal.Customer;
import com.blog.modal.LoginDTO;
import com.blog.repo.CurrentUserSessionRepo;
import com.blog.repo.CustomerRepo;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;

import net.bytebuddy.utility.RandomString;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private CustomerRepo customerRepo;


	@Autowired
	private CurrentUserSessionRepo sessionRepo;

	@Override
	public String loginAccount(LoginDTO loginDTO) throws LoginException {

		if (!loginDTO.getRole().equalsIgnoreCase("customer") && !loginDTO.getRole().equalsIgnoreCase("admin"))
			throw new LoginException("Please enter a valid role");

		if (loginDTO.getRole().equalsIgnoreCase("customer")) {
			Customer customer = customerRepo.findByEmail(loginDTO.getEmail());
			if (customer == null)
				throw new LoginException("Invalid email");

			if (customer.getPassword().equals(loginDTO.getPassword())) {

				CurrentUserSession cuurSession = sessionRepo.findByEmail(loginDTO.getEmail());

				if (cuurSession != null)
					throw new LoginException("User already logged-In!");

				CurrentUserSession currentUserSession = new CurrentUserSession();
				currentUserSession.setEmail(loginDTO.getEmail());
				currentUserSession.setLoginDateTime(LocalDateTime.now());
				currentUserSession.setRole("customer");
				String privateKey = RandomString.make(6);
				currentUserSession.setPrivateKey(privateKey);

				sessionRepo.save(currentUserSession);
				return "Login Sucessufull!"+"Your Private key: "+privateKey ;
			} else {
				throw new LoginException("Please Enter a valid password");
			}

		}
		
		return null;
	}

	@Override
	public String logoutAccount(String role, String key) throws LoginException {

		if (!role.equalsIgnoreCase("customer") && !role.equalsIgnoreCase("admin"))
			throw new LoginException("Please enter a valid role");

		if (role.equalsIgnoreCase("customer")) {

			CurrentUserSession currSession = sessionRepo.findByPrivateKey(key);
			if (currSession == null)
				throw new LoginException("Invalid key");

			if (currSession.getRole().equalsIgnoreCase("customer")) {

				sessionRepo.delete(currSession);
				return "Logged Out!";

			} else
				throw new LoginException("Invalid role");

		}  else
			throw new LoginException("Invalid role");
	}
}
