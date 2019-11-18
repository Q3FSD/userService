package com.mentorondemand.userservice.entities;

import java.io.Serializable;

public class SkillsId implements Serializable {
	private static final long serialVersionUID = 1L;

	private Users user;

	private Technologies tech;

	public SkillsId() {
	}

	public SkillsId(Users user, Technologies tech) {
		this.user = user;
		this.tech = tech;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public Technologies getTech() {
		return tech;
	}

	public void setTech(Technologies tech) {
		this.tech = tech;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;

		SkillsId that = (SkillsId) obj;

		if (!user.getUserName().equals(that.getUser().getUserName()))
			return false;
		return tech.getSkillName().equals(that.getTech().getSkillName());
	}

	@Override
	public int hashCode() {
		int result = user.getUserName().hashCode();
		result = 31 * result + tech.getSkillName().hashCode();
		return result;
	}
}
