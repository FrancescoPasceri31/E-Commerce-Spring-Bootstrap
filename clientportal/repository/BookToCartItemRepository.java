package com.myBookstoreProject.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.myBookstoreProject.domain.BookToCartItem;
import com.myBookstoreProject.domain.CartItem;

@Transactional
public interface BookToCartItemRepository extends CrudRepository<BookToCartItem, Long> {

	void deleteByCartItem(CartItem cartItem);

}
