package com.springboot.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.demo.model.RoleName;
import com.springboot.demo.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
	Optional<Role> findByName(RoleName roleName);
}
