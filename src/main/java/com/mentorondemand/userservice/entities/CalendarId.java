package com.mentorondemand.userservice.entities;

import java.io.Serializable;
import java.util.Date;

public class CalendarId implements Serializable {
	private static final long serialVersionUID = 1L;

	private Users user;

	private Date startDate;

	private Date endDate;

	public CalendarId() {
	}

	public CalendarId(Users user, Date startDate, Date endDate) {
		this.user = user;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public Users getUser() {
		return user;
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

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;

		CalendarId that = (CalendarId) obj;

		if (!user.getUserName().equals(that.getUser().getUserName()))
			return false;
		if (startDate.equals(that.startDate))
			return false;
		return endDate.equals(that.endDate);
	}

	@Override
	public int hashCode() {
		int result = user.getUserName().hashCode();
		result = 31 * result + startDate.hashCode();
		result = 31 * result + endDate.hashCode();
		return result;
	}
}
