package com.mentorondemand.userservice.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * The persistent class for the mentor skills database table.
 * 
 */
@Entity
@IdClass(SkillsId.class)
@Table(name = "mentor_skills")
public class MentorSkills implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@ManyToOne
	@JoinColumn(name = "user_name", referencedColumnName = "user_name")
	private Users user;

	@Id
	@ManyToOne
	@JoinColumn(name = "skill_name", referencedColumnName = "skill_name")
	private Technologies tech;

	public MentorSkills() {
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public String getTechnologies() {
		return tech.getSkillName();
	}

	public void setTechnologies(Technologies tech) {
		this.tech = tech;
	}

}