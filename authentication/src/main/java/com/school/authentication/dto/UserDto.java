package com.school.authentication.dto;

import java.util.ArrayList;
import java.util.List;

public class UserDto {

	private final String userName;
	
	private final Name name;
	
	private final boolean newUser;
	
	private final List<UserRoleDto> roles;
	
	public UserDto(String userName, Name name, boolean newUser, List<UserRoleDto> roles) {
		this.userName = userName;
		this.name = name;
		this.newUser = newUser;
		this.roles = new ArrayList<>(roles);
	}

	public String getUserName() {
		return userName;
	}

	public Name getName() {
		return name;
	}

	public boolean isNewUser() {
		return newUser;
	}

	public List<UserRoleDto> getRoles() {
		return roles;
	}
	
	
	
}
