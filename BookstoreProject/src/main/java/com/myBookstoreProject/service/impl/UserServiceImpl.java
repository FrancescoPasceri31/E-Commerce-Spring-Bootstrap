package com.myBookstoreProject.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myBookstoreProject.domain.User;
import com.myBookstoreProject.domain.UserBilling;
import com.myBookstoreProject.domain.UserPayment;
import com.myBookstoreProject.domain.UserShipping;
import com.myBookstoreProject.domain.security.PasswordResetToken;
import com.myBookstoreProject.domain.security.ShoppingCart;
import com.myBookstoreProject.domain.security.UserRole;
import com.myBookstoreProject.repository.PasswordResetTokenRepository;
import com.myBookstoreProject.repository.RoleRepository;
import com.myBookstoreProject.repository.UserPaymentRepository;
import com.myBookstoreProject.repository.UserRepository;
import com.myBookstoreProject.repository.UserShippingRepository;
import com.myBookstoreProject.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	private static final Logger LOG = LoggerFactory.getLogger(UserService.class);

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private PasswordResetTokenRepository passwordResetTokenRepository;

	@Autowired
	private UserPaymentRepository userPaymentRepository;

	@Autowired
	private UserShippingRepository userShippingRepository;

	@Override
	public PasswordResetToken getPasswordResetToken(final String token) {
		return passwordResetTokenRepository.findByToken(token);
	}

	@Override
	public void createPasswordResetTokenForUser(final User user, final String token) {
		final PasswordResetToken myToken = new PasswordResetToken(token, user);
		passwordResetTokenRepository.save(myToken);
	}

	@Override
	public User findByUsername(String username) {
		return userRepository.findByUsername(username);
	}

	@Override
	public User findByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	@Override
	@Transactional
	public User createUser(User user, List<UserRole> userRoles) throws Exception {
		User localUser = userRepository.findByUsername(user.getUsername());

		if (localUser != null) {
			LOG.info("user {} already exists. Nothing will be done.", user.getUsername());
		} else {
			for (int i = 0; i < userRoles.size(); i++) {
				userRoles.get(i).setRole(roleRepository.save(userRoles.get(i).getRole()));
			}

			user.getUserRoles().addAll(userRoles);

			ShoppingCart shoppingCart = new ShoppingCart();
			shoppingCart.setUser(user);
			user.setShoppingCart(shoppingCart);

			user.setUserShippingList(new ArrayList<UserShipping>());
			user.setUserPaymentList(new ArrayList<UserPayment>());

			localUser = userRepository.save(user);
		}
		return localUser;
	}

	@Override
	public User save(User user) {
		return userRepository.save(user);
	}

	@Override
	public void updateUserBilling(UserBilling userBilling, UserPayment userPayment, User user) {
		userPayment.setUser(user);
		userPayment.setUserBilling(userBilling);
		userPayment.setDefaultPayment(true);
		userBilling.setUserPayment(userPayment);
		user.getUserPaymentList().add(userPayment);
		save(user);
	}

	@Override
	public void setUserDefaultPayment(Long userPaymentId, User user) {
		List<UserPayment> userPaymentList = (List<UserPayment>) userPaymentRepository.findAll();

		for (UserPayment userPayment : userPaymentList) {
			if (userPayment.getId() == userPaymentId) {
				userPayment.setDefaultPayment(true);
				userPaymentRepository.save(userPayment);
			} else {
				userPayment.setDefaultPayment(false); // un solo metodo di pagamento
				userPaymentRepository.save(userPayment);
			}
		}

	}

	@Override
	public void updateUserShipping(UserShipping userShipping, User user) {
		userShipping.setUser(user);
		userShipping.setUserShippingDefault(true);
		user.getUserShippingList().add(userShipping);
		save(user);
	}

	@Override
	public void setUserDefaultShippingAddress(Long userShippingId, User user) {
		List<UserShipping> userShippingList = (List<UserShipping>) userShippingRepository.findAll();

		for (UserShipping userShipping : userShippingList) {
			if (userShipping.getId() == userShippingId) {
				userShipping.setUserShippingDefault(true);
				userShippingRepository.save(userShipping);
			} else {
				userShipping.setUserShippingDefault(false); // un solo metodo di pagamento
				userShippingRepository.save(userShipping);
			}
		}
	}

	@Override
	public User findById(Long id) {
		return userRepository.findById(id).orElse(null);
	}

}