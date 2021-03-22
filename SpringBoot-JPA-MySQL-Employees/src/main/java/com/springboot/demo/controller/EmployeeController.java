package com.springboot.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.demo.model.Employee;
import com.springboot.demo.repository.EmployeeRepository;

@RestController
@RequestMapping("/api")
public class EmployeeController {
	@Autowired
	EmployeeRepository employeeRepository;
	
	@GetMapping("/employees")
	public List<Employee> getAll(){
		return employeeRepository.findAll();
	}
	@PostMapping("/create")
	public Employee CreateEmployee(@RequestBody Employee employee) {
		return employeeRepository.save(new Employee(employee.getFirstName(), employee.getLastName(), employee.getEmailId()));
	}
}
