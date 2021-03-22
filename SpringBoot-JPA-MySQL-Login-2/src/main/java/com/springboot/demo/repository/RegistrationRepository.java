package com.springboot.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.demo.model.Login;

public interface RegistrationRepository extends JpaRepository<Login, Integer> {
	public Login findByEmailId(String emailId);
	public Login findByEmailIdAndPassword(String emailId, String password);
	
}
