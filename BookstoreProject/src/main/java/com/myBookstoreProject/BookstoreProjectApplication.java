package com.myBookstoreProject;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.myBookstoreProject.domain.User;
import com.myBookstoreProject.domain.security.Role;
import com.myBookstoreProject.domain.security.UserRole;
import com.myBookstoreProject.service.UserService;
import com.myBookstoreProject.utility.SecurityUtility;

@SpringBootApplication
public class BookstoreProjectApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreProjectApplication.class, args);
	}

	@Autowired
	private UserService userService;

	@Override
	public void run(String... args) throws Exception {
		User user1 = new User();
		user1.setFirstName("New");
		user1.setLastName("User");
		user1.setUsername("j");
		user1.setPassword(SecurityUtility.passwordEncoder().encode("p"));
		user1.setEmail("newUser@gmail.com");
		List<UserRole> userRoles = new ArrayList<>();
		Role role1 = new Role();
		role1.setRoleId(1);
		role1.setName("ROLE_USER");
		userRoles.add(new UserRole(user1, role1));

		userService.createUser(user1, userRoles);
	}
}
