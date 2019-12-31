package com.myBookstoreProject.service;

import com.myBookstoreProject.domain.Payment;
import com.myBookstoreProject.domain.UserPayment;

public interface PaymentService {

	Payment setByUserPayment(UserPayment userPayment, Payment payment);

}
