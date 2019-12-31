package com.myBookstoreProject.service;

import com.myBookstoreProject.domain.BillingAddress;
import com.myBookstoreProject.domain.UserBilling;

public interface BillingAddressService {

	BillingAddress setByUserBilling(UserBilling userBilling, BillingAddress billingAddress);

}
