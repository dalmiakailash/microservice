package com.school.authentication.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.school.authentication.model.User;

@Repository
public interface AuthenticationRepository extends CrudRepository<User, Integer>{

	public User findByUserName(final String userId);
	
}
