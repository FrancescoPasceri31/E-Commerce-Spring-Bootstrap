package com.myBookstoreProject.service;

import com.myBookstoreProject.domain.UserPayment;

public interface UserPaymentService {

	UserPayment findById(Long id);

	void removeById(Long creditCardId);
}
