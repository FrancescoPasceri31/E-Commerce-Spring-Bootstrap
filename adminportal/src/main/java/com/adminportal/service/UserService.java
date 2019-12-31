package com.adminportal.service;

import java.util.List;

import com.adminportal.domain.User;
import com.adminportal.domain.security.UserRole;

public interface UserService {

	User createUser(User user, List<UserRole> userRoles) throws Exception;

	User save(User user);
}
