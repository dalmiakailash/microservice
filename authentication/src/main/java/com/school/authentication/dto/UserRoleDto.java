package com.school.authentication.dto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UserRoleDto {

	private final String role;
	
	private final List<String> permissions;

	public UserRoleDto(String role, List<String> permissions) {
		this.role = role;
		this.permissions = new ArrayList<>(permissions);
	}

	public String getRole() {
		return role;
	}

	public List<String> getPermissions() {
		return Collections.unmodifiableList(permissions);
	}
	
	
	
}
