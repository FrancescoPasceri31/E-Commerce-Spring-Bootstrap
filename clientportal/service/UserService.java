package com.myBookstoreProject.service;

import java.util.List;

import com.myBookstoreProject.domain.User;
import com.myBookstoreProject.domain.UserBilling;
import com.myBookstoreProject.domain.UserPayment;
import com.myBookstoreProject.domain.UserShipping;
import com.myBookstoreProject.domain.security.PasswordResetToken;
import com.myBookstoreProject.domain.security.UserRole;

public interface UserService {

	PasswordResetToken getPasswordResetToken(final String token);

	void createPasswordResetTokenForUser(final User user, final String token);

	User findByUsername(String username);

	User findByEmail(String email);

	User createUser(User user, List<UserRole> userRoles) throws Exception;

	User save(User user);

	void updateUserBilling(UserBilling userBilling, UserPayment userPayment, User user);

	void setUserDefaultPayment(Long userPaymentId, User user);

	void updateUserShipping(UserShipping userShipping, User user);

	void setUserDefaultShippingAddress(Long userShippingId, User user);

	User findById(Long id);
}
