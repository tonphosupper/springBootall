package com.springboot.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springboot.demo.model.User;
import com.springboot.demo.repository.UserRepository;

@Controller
@RequestMapping(path = "/demo")
public class UserController {
	@Autowired
	private UserRepository repository;
	
	@PostMapping(path = "/add")
	public @ResponseBody String addNewUser(@RequestParam String name, @RequestParam String email) {
		User user = new User();
		user.setName(name);
		user.setEmail(email);
		repository.save(user);
		return "Saved";
	}
	
	@GetMapping(path = "/all")
	public @ResponseBody Iterable<User> getAllUsers(){
		return repository.findAll();
	}
	@DeleteMapping(path = "{id}")
	public String deleteUser(@PathVariable("id") int id) {
		repository.deleteById(id);
		return "Complete";
	}
}
