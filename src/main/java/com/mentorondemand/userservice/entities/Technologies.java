package com.mentorondemand.userservice.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * The persistent class for the technologies database table.
 * 
 */
@Entity
@Table(name = "technologies")
public class Technologies implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "skill_name", nullable = false)
	private String skillName;

	@Column(name = "description")
	private String description;

	@Column(name = "prerequisites")
	private String prerequisites;

	// bi-directional many-to-one association to MentorSkills
	@OneToMany(mappedBy = "tech")
	private List<MentorSkills> mentorSkills;

	public Technologies() {
	}

	public String getSkillName() {
		return skillName;
	}

	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPrerequisites() {
		return prerequisites;
	}

	public void setPrerequisites(String prerequisites) {
		this.prerequisites = prerequisites;
	}

	public List<MentorSkills> getMentorSkills() {
		return this.mentorSkills;
	}

	public void setMentorSkills(List<MentorSkills> mentorSkills) {
		this.mentorSkills = mentorSkills;
	}

	public MentorSkills addMentorSkills(MentorSkills mentorSkills) {
		getMentorSkills().add(mentorSkills);
		mentorSkills.setTechnologies(this);

		return mentorSkills;
	}

	public MentorSkills removeMentorSkills(MentorSkills mentorSkills) {
		getMentorSkills().remove(mentorSkills);
		mentorSkills.setTechnologies(null);

		return mentorSkills;
	}
}