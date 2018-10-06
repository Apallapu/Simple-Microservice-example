package com.ankamma.user.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ankamma.user.application.model.UserRequest;
import com.ankamma.user.application.model.UserResponse;
import com.ankamma.user.application.persistence.User;
import com.ankamma.user.application.respository.UserJpaRepository;
import com.ankamma.user.application.util.UserUtil;

@Service
public class UserService {

	@Autowired
	private UserJpaRepository userJpaRepository;
	@Autowired
	private UserUtil userUtil;

	public UserResponse createUser(UserRequest userRequest) {
		UserResponse response = new UserResponse();
		User user = userUtil.transformUser(userRequest);
		user = userJpaRepository.save(user);
		response.setId(user.getId());
		return response;
	}

}
