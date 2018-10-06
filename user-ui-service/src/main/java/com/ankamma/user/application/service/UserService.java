package com.ankamma.user.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ankamma.user.application.model.UserRequest;
import com.ankamma.user.application.model.UserResponse;

@Service
public class UserService {

	@LoadBalanced
	@Autowired
	RestTemplate restTemplate;

	@Value("${userdomainserviceUrl}")
	private String userdomainserviceUrl;

	public UserResponse createUser(UserRequest userRequest) {

		StringBuilder url = new StringBuilder();
		url.append(userdomainserviceUrl).append("/users");

		UserResponse response = restTemplate.postForObject(url.toString(), userRequest, UserResponse.class);

		return response;
	}

}
