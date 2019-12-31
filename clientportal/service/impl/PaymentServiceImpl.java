package com.myBookstoreProject.service.impl;

import org.springframework.stereotype.Service;

import com.myBookstoreProject.domain.Payment;
import com.myBookstoreProject.domain.UserPayment;
import com.myBookstoreProject.service.PaymentService;

@Service
public class PaymentServiceImpl implements PaymentService {

	@Override
	public Payment setByUserPayment(UserPayment userPayment, Payment payment) {
		payment.setType(userPayment.getType());
		payment.setHolderName(userPayment.getHolderName());
		payment.setCardNumber(userPayment.getCardNumber());
		payment.setExpiryMonth(userPayment.getExpiryMonth());
		payment.setExpiryYear(userPayment.getExpiryYear());
		payment.setCvc(userPayment.getCvc());
		
		return payment;
	}

}
