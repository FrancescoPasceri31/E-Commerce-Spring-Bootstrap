package com.myBookstoreProject.service;

import com.myBookstoreProject.domain.ShippingAddress;
import com.myBookstoreProject.domain.UserShipping;

public interface ShippingAddressService {

	ShippingAddress setByUserShipping(UserShipping userShipping, ShippingAddress shippingAddress);

}
