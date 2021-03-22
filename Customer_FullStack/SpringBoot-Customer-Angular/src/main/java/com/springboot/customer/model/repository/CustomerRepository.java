package com.springboot.customer.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.customer.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
	List<Customer> findByAge(int age);
}
