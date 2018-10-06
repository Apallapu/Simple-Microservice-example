package com.ankamma.user.application.util;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.ankamma.user.application.model.RoleRequest;
import com.ankamma.user.application.model.UserRequest;
import com.ankamma.user.application.persistence.Role;
import com.ankamma.user.application.persistence.User;

@Component
public class UserUtil {

	public User transformUser(UserRequest userRequest) {
		User user = new User();
		Date d=new Date();
		user.setCreatedAt(new Timestamp(d.getDate()));
		user.setEmail(userRequest.getEmail());
		user.setName(userRequest.getName());
		user.setPassword(userRequest.getPassword());
		user.setUpdatedAt(new Timestamp(d.getDate()));
		user.setUsername(userRequest.getUsername());
		user.setRoles1(setRoles(user, userRequest.getRoleRequest()));
		return user;
	}

	private Set<Role> setRoles(User user, List<RoleRequest> roleRequest) {
		Set<Role> list = new HashSet<>();
		roleRequest.stream().forEach(role -> list.add(setRole(role, user)));
		return list;
	}

	private Role setRole(RoleRequest role, User user) {
		Role role2 = new Role();
		Set<User> users1 = new HashSet<>();
		users1.add(user);
		role2.setUsers1(users1);
		role2.setId(role.getId());
		role2.setName(role.getName());
		return role2;
	}

}
