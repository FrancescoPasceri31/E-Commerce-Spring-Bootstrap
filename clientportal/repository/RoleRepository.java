package com.myBookstoreProject.repository;

import org.springframework.data.repository.CrudRepository;

import com.myBookstoreProject.domain.security.Role;

public interface RoleRepository extends CrudRepository<Role, Long> {

	Role findByName(String name);
}
