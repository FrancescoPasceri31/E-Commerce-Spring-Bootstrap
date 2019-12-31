package com.myBookstoreProject.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myBookstoreProject.domain.UserShipping;
import com.myBookstoreProject.repository.UserShippingRepository;
import com.myBookstoreProject.service.UserShippingService;

@Service
public class UserShippingServiceImpl implements UserShippingService {

	@Autowired
	private UserShippingRepository userShippingRepository;

	@Override
	public UserShipping findById(Long shippingAddressId) {
		return userShippingRepository.findById(shippingAddressId).orElse(null);
	}

	@Override
	public void removeById(Long userShippingAddressId) {
		userShippingRepository.deleteById(userShippingAddressId);
	}

}
