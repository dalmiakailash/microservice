package com.school.authentication.service;

import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.school.authentication.dto.Name;
import com.school.authentication.dto.UserDto;
import com.school.authentication.dto.UserRoleDto;
import com.school.authentication.model.Role;
import com.school.authentication.model.User;
import com.school.authentication.model.UserPermission;
import com.school.authentication.repository.AuthenticationRepository;

@Service
public class AuthenticationService {

	@Autowired
	private AuthenticationRepository authenticationRepository;
	
	public UserDto findUserDetails(final String userName) {
		final User user = authenticationRepository.findByUserName(userName);
		if(Objects.nonNull(user)) {
			return new UserDto(userName, new Name(user.getFirstName(), user.getLasttName()), user.isNewUser(), fetchUserRoles(user.getRoles()));
		}else {
			throw new UsernameNotFoundException(userName+" is not a valid user.");
		}
	}

	private List<UserRoleDto> fetchUserRoles(Set<Role> roles) {
		return roles.stream().map(role -> new UserRoleDto(role.getRole().name(),
				role.getRole().getPermissions().stream().map(UserPermission::name).collect(Collectors.toList())))
				.collect(Collectors.toList());
	}
	
}
