package com.myBookstoreProject.repository;

import org.springframework.data.repository.CrudRepository;

import com.myBookstoreProject.domain.security.ShoppingCart;

public interface ShoppingCartRepository extends CrudRepository<ShoppingCart, Long> {

}
