package com.mentorondemand.userservice.services;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.mentorondemand.userservice.entities.Technologies;

//This will be AUTO IMPLEMENTED by Spring into a Bean called technologyRepository
//CRUD refers Create, Read, Update, Delete

public interface TechnologyRepository extends CrudRepository<Technologies, Integer> {

	@Transactional
	Optional<Technologies> deleteBySkillName(String skillName);
}
