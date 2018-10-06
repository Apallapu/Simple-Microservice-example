package com.ankamma.user.application.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ankamma.user.application.model.UserRequest;
import com.ankamma.user.application.model.UserResponse;
import com.ankamma.user.application.service.UserService;

@RestController
public class UserController {
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	@Autowired
	private UserService userService;

	@PostMapping(path = "/users", consumes = "application/json", produces = "application/json")
	public UserResponse createUser(@RequestBody UserRequest UserRequest) {
		return userService.createUser(UserRequest);
		
	}
      
}
