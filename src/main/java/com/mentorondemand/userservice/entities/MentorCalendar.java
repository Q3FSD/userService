package com.mentorondemand.userservice.entities;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * The persistent class for the mentor calendar database table.
 * 
 */
@Entity
@Table(name = "mentor_calendar")
public class MentorCalendar implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	// bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name = "user_name", referencedColumnName = "user_name")
	private Users user;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	@Column(name = "start_date")
	private Date startDate;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	@Column(name = "end_date")
	private Date endDate;

	@DateTimeFormat(pattern = "hh-MM-ss")
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "start_time")
	private Calendar startTime;

	@DateTimeFormat(pattern = "hh-MM-ss")
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "end_time")
	private Calendar endTime;

	public MentorCalendar() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Calendar getStartTime() {
		return startTime;
	}

	public void setStartTime(Calendar startTime) {
		this.startTime = startTime;
	}

	public Calendar getEndTime() {
		return endTime;
	}

	public void setEndTime(Calendar endTime) {
		this.endTime = endTime;
	}

}