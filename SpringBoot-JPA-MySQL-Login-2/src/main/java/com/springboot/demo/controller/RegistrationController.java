package com.springboot.demo.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.demo.model.Login;
import com.springboot.demo.repository.RegistrationRepository;
import com.springboot.demo.service.RegistrationService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/")
public class RegistrationController {

	@Autowired
	private RegistrationService service;

	@Autowired
	RegistrationRepository repository;

	@PostMapping("/registeruser")
	public Login RegisterUser(@RequestBody Login user) throws Exception {
		String tempEmailId = user.getEmailId();
		if (tempEmailId != null && !"".equals(tempEmailId)) {
			Login useobj = service.fetchUserByEmailId(tempEmailId);
			if (useobj != null) {
				throw new Exception("user with " + tempEmailId + " already exist");
			}
		}
		Login userObj = null;
		userObj = service.saveUser(user);
		return userObj;
	}

	@PostMapping("/login")
	public String loginUser(@RequestBody Login user) throws Exception {
		String tempEmailId = user.getEmailId();
		String tempPass = user.getPassword();
		Login userObj = null;
		if (tempEmailId != null && tempPass != null) {
			userObj = service.fetchUserByEmailIdAndPassword(tempEmailId, tempPass);
		}	
		if (userObj == null) {
			throw new Exception("Bad credentials");
		}
		return userObj.getRoles();
	}

	@GetMapping("/auth")
	public Principal user(Principal user) {
		return user;
	}

	@DeleteMapping("/deleteuser/{id}")
	public ResponseEntity<Login> deleteCustomer(@PathVariable("id") int id) {
		System.out.println("Delete user with ID = " + id + "...");

		repository.deleteById(id);

		return new ResponseEntity<Login>(HttpStatus.OK);
	}

	@GetMapping("/user")
	public List<Login> getAll() {
		return repository.findAll();
	}

}
