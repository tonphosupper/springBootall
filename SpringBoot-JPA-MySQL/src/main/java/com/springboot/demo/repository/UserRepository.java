package com.springboot.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.springboot.demo.model.User;

public interface UserRepository extends CrudRepository<User, Integer> {

}
