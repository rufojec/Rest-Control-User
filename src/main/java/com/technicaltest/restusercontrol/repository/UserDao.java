package com.technicaltest.restusercontrol.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.technicaltest.restusercontrol.model.User;

public interface UserDao extends CrudRepository<User, Integer> {

	User findByEmail(String email);
	
}
