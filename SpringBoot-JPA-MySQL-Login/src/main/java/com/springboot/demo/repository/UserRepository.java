package com.springboot.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.demo.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	Optional<User> findByUsername(String userName);

	Boolean existsByUsername(String userName);

	Boolean existsByEmail(String email);

}
