package com.vinayak.microservice.v2.orderservice.repository;

import com.vinayak.microservice.v2.orderservice.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
