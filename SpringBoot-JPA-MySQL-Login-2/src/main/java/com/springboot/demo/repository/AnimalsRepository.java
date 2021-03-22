package com.springboot.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.demo.model.Animals;

public interface AnimalsRepository extends JpaRepository<Animals, Long> {
	List<Animals> findByNameContaining(String name);
	
}
