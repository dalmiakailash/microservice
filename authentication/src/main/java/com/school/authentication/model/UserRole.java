package com.school.authentication.model;

import java.util.Arrays;
import java.util.List;

public enum UserRole {

	ADMIN(Arrays.asList(UserPermission.STUDENT_RECORD_CREATE, UserPermission.STUDENT_RECORD_MODIFY,
			UserPermission.STUDENT_RECORD_READ, UserPermission.LIBRARY_ASSIGNED_BOOK_READ,
			UserPermission.STUDENT_FEE_READ, UserPermission.STUDENT_COURSE_READ, UserPermission.STUDENT_COURSE_WRITE,
			UserPermission.STUDENT_COURSE_CREATE)),

	LIBRARIAN(Arrays.asList(UserPermission.STUDENT_RECORD_READ, UserPermission.LIBRARY_ASSIGNED_BOOK_READ,
			UserPermission.LIBRARY_BOOK_ADD, UserPermission.LIBRARY_BOOK_ASSIGN, UserPermission.LIBRARY_BOOK_DELETE)),

	ACCOUNTS(Arrays.asList(UserPermission.STUDENT_RECORD_READ, UserPermission.STUDENT_FEE_READ,
			UserPermission.STUDENT_FEE_MODIFY)),

	TEACHER(Arrays.asList(UserPermission.STUDENT_RECORD_READ, UserPermission.STUDENT_COURSE_READ,
			UserPermission.STUDENT_COURSE_WRITE, UserPermission.STUDENT_COURSE_CREATE)),

	STUDENT(Arrays.asList(UserPermission.STUDENT_RECORD_READ, UserPermission.LIBRARY_ASSIGNED_BOOK_READ,
			UserPermission.STUDENT_FEE_READ, UserPermission.STUDENT_COURSE_READ));

	private final List<UserPermission> permissions;

	private UserRole(List<UserPermission> permissions) {
		this.permissions = permissions;
	}

	public List<UserPermission> getPermissions() {
		return permissions;
	}

}
