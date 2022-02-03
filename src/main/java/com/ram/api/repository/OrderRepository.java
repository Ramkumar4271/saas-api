package com.ram.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ram.api.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
