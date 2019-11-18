package com.mentorondemand.userservice.services;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.mentorondemand.userservice.entities.MentorSkills;
import com.mentorondemand.userservice.entities.SkillsId;
import com.mentorondemand.userservice.entities.Users;

//This will be AUTO IMPLEMENTED by Spring into a Bean called mentorSkillsRepository
//CRUD refers Create, Read, Update, Delete

public interface MentorSkillsRepository extends CrudRepository<MentorSkills, SkillsId> {

	@Modifying
	@Query(value = "INSERT IGNORE INTO mentor_skills (user_name, skill_name) VALUES (:userName, :skillName)", nativeQuery = true)
	@Transactional
	int add(String userName, String skillName);

	@Transactional
	Iterable<MentorSkills> deleteAllByUser(Users user);

	Iterable<MentorSkills> findAllByUser(Users user);
}
