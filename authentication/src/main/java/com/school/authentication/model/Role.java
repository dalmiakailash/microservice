package com.school.authentication.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToMany;

@Entity(name = "roles")
public class Role extends Identity {

	@Column(name = "role")
	@Enumerated(EnumType.STRING)
	private UserRole role;
	
	@ManyToMany(mappedBy="roles")
	private Set<User> users = new HashSet<>();

	public UserRole getRole() {
		return role;
	}

	public void setRole(UserRole role) {
		this.role = role;
	}
	
}
