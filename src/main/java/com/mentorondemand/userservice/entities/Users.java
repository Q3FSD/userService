package com.mentorondemand.userservice.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Pattern;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * The persistent class for the users database table.
 * 
 */
@Entity
@Table(name = "users")
public class Users implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Pattern(regexp = "^[a-zA-Z]\\w{5,17}$", message = "User name must start with letter, length between 6 to 18 and only include letter, number and underline.")
	@Column(name = "user_name", nullable = false)
	private String userName;

	@Pattern(regexp = "^[a-zA-Z]\\w{5,17}$", message = "Password must start with letter, length between 6 to 18 and only include letter, number and underline.")
	@Column(name = "password", nullable = false)
	private String password;

	@Pattern(regexp = "^.{0,19}$", message = "First name can not exceed 20 chars.")
	@Column(name = "first_name")
	private String firstName;

	@Pattern(regexp = "^.{0,19}$", message = "Last name can not exceed 20 chars.")
	@Column(name = "last_name")
	private String lastName;

	@Pattern(regexp = "^\\d{11,11}$", message = "Phone number must be 11 digits.")
	@Column(name = "contact_number")
	private String contactNumber;

	@Pattern(regexp = "^.{0,19}$", message = "Your region code can not exceed 20 chars.")
	@Column(name = "reg_code")
	private String regCode = "";

	@Column(name = "role")
	private String role = "Student";

	@Column(name = "linkedin_url")
	private String linkedinUrl = null;

	@Column(name = "years_of_experience")
	private Float yearsOfExperience;

	@Column(name = "active")
	private Boolean active = false;

	@Column(name = "confirmed_signup")
	private Boolean confirmedSignup = false;

	@Column(name = "reset_password")
	private Boolean resetPassword = false;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	@Column(name = "reset_password_date")
	private Date resetPasswordDate;

	// bi-directional many-to-one association to MentorCalendar
	@OneToMany(mappedBy = "user")
	private List<MentorCalendar> mentorCalendar;

	// bi-directional many-to-one association to MentorSkills
	@OneToMany(mappedBy = "user")
	private List<MentorSkills> mentorSkills;

	public Users() {
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getRegCode() {
		return regCode;
	}

	public void setRegCode(String regCode) {
		this.regCode = regCode;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getLinkedinUrl() {
		return linkedinUrl;
	}

	public void setLinkedinUrl(String linkedinUrl) {
		this.linkedinUrl = linkedinUrl;
	}

	public Float getYearsOfExperience() {
		return yearsOfExperience;
	}

	public void setYearsOfExperience(Float yearsOfExperience) {
		this.yearsOfExperience = yearsOfExperience;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public Boolean getConfirmedSignup() {
		return confirmedSignup;
	}

	public void setConfirmedSignup(Boolean confirmedSignup) {
		this.confirmedSignup = confirmedSignup;
	}

	public Boolean getResetPassword() {
		return resetPassword;
	}

	public void setResetPassword(Boolean resetPassword) {
		this.resetPassword = resetPassword;
	}

	public Date getResetPasswordDate() {
		return resetPasswordDate;
	}

	public void setResetPasswordDate(Date resetPasswordDate) {
		this.resetPasswordDate = resetPasswordDate;
	}

	public List<MentorCalendar> getMentorCalendar() {
		return this.mentorCalendar;
	}

	public void setMentorCalendar(List<MentorCalendar> mentorCalendar) {
		this.mentorCalendar = mentorCalendar;
	}

	public MentorCalendar addMentorCalendar(MentorCalendar mentorCalendar) {
		getMentorCalendar().add(mentorCalendar);
		mentorCalendar.setUser(this);

		return mentorCalendar;
	}

	public MentorCalendar removeMentorCalendar(MentorCalendar mentorCalendar) {
		getMentorCalendar().remove(mentorCalendar);
		mentorCalendar.setUser(null);

		return mentorCalendar;
	}

	public List<MentorSkills> getMentorSkills() {
		return this.mentorSkills;
	}

	public void setMentorSkills(List<MentorSkills> mentorSkills) {
		this.mentorSkills = mentorSkills;
	}

	public MentorSkills addMentorSkills(MentorSkills mentorSkills) {
		getMentorSkills().add(mentorSkills);
		mentorSkills.setUser(this);

		return mentorSkills;
	}

	public MentorSkills removeMentorSkills(MentorSkills mentorSkills) {
		getMentorSkills().remove(mentorSkills);
		mentorSkills.setUser(null);

		return mentorSkills;
	}
}