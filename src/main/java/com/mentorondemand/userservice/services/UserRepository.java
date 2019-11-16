package com.mentorondemand.userservice.services;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.mentorondemand.userservice.entities.Users;

//This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
//CRUD refers Create, Read, Update, Delete

public interface UserRepository extends CrudRepository<Users, Integer> {

	Optional<Users> findByUserName(String userName);

	@Transactional
	Optional<Users> deleteByUserName(String userName);
}
