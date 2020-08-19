package com.school.authentication.controller;

import java.security.Principal;

import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.school.authentication.dto.UserDto;
import com.school.authentication.service.AuthenticationService;

@RestController
@RequestMapping("/user/")
public class AuthenticationController {
	
	@Autowired
	private AuthenticationService authenticationService;

	@PostMapping("register")
	@Consumes(value= {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Response register(@RequestBody UserDto user) {
		return Response.ok().build();
	}
	
	@PutMapping("deactivate")
	public Response deactivate() {
		return Response.ok().build();
	}
	
	@GetMapping("details")
	public UserDto details(final Principal principal) {
		return authenticationService.findUserDetails(principal.getName());
	}
	
}
