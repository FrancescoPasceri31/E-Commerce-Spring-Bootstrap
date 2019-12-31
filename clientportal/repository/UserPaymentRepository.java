package com.myBookstoreProject.repository;

import org.springframework.data.repository.CrudRepository;

import com.myBookstoreProject.domain.UserPayment;

public interface UserPaymentRepository extends CrudRepository<UserPayment, Long> {

	
	
}
