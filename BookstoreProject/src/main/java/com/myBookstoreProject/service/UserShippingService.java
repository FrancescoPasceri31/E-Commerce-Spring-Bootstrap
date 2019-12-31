package com.myBookstoreProject.service;

import com.myBookstoreProject.domain.UserShipping;

public interface UserShippingService {

	UserShipping findById(Long shippingAddressId);

	void removeById(Long userShippingAddressId);

}
