package com.springboot.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.demo.model.Login;
import com.springboot.demo.repository.RegistrationRepository;

@Service
public class RegistrationService {
	
	@Autowired
	private RegistrationRepository repository;
	public Login saveUser(Login user) {
		return repository.save(user);
	}
	
	public Login fetchUserByEmailId(String email) {
		return repository.findByEmailId(email);
	}
	public Login fetchUserByEmailIdAndPassword(String email, String password) {
		return repository.findByEmailIdAndPassword(email, password);
	}
	
}
