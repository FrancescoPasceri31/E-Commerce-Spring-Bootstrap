package com.myBookstoreProject.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myBookstoreProject.domain.UserPayment;
import com.myBookstoreProject.repository.UserPaymentRepository;
import com.myBookstoreProject.service.UserPaymentService;

@Service
public class UserPaymentServiceImpl implements UserPaymentService {

	@Autowired
	private UserPaymentRepository userPaymentRepository;
	
	@Override
	public UserPayment findById(Long id) {
		return userPaymentRepository.findById(id).orElse(null);
	}

	@Override
	public void removeById(Long creditCardId) {
		userPaymentRepository.deleteById(creditCardId);
	}

}
