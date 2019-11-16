package com.mentorondemand.userservice.services;

import org.springframework.data.repository.CrudRepository;

import com.mentorondemand.userservice.entities.MentorCalendar;
import com.mentorondemand.userservice.entities.Users;

//This will be AUTO IMPLEMENTED by Spring into a Bean called mentorCalendarRepository
//CRUD refers Create, Read, Update, Delete

public interface MentorCalendarRepository extends CrudRepository<MentorCalendar, Integer> {

	Iterable<MentorCalendar> findAllByUser(Users user);
}
