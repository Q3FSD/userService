package com.mentorondemand.userservice.services;

import java.util.Date;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.mentorondemand.userservice.entities.CalendarId;
import com.mentorondemand.userservice.entities.MentorCalendar;
import com.mentorondemand.userservice.entities.Users;

//This will be AUTO IMPLEMENTED by Spring into a Bean called mentorCalendarRepository
//CRUD refers Create, Read, Update, Delete

public interface MentorCalendarRepository extends CrudRepository<MentorCalendar, CalendarId> {

	@Modifying
	@Query(value = "INSERT IGNORE INTO mentor_calendar (user_name, start_time, end_time) VALUES (:userName, :startDate, :endDate)", nativeQuery = true)
	@Transactional
	int add(String userName, Date startDate, Date endDate);

	@Modifying
	@Query(value = "DELETE FROM mentor_calendar WHERE user_name=:userName AND start_time=:startDate AND end_time=:endDate", nativeQuery = true)
	@Transactional
	int delete(String userName, Date startDate, Date endDate);

	Iterable<MentorCalendar> findAllByUser(Users user);
}
