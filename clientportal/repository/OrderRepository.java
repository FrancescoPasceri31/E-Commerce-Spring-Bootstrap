package com.myBookstoreProject.repository;

import org.springframework.data.repository.CrudRepository;

import com.myBookstoreProject.domain.Order;

public interface OrderRepository extends CrudRepository<Order, Long> {

}
