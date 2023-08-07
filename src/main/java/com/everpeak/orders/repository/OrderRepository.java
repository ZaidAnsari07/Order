package com.everpeak.orders.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.everpeak.orders.entity.Orders;

public interface OrderRepository extends JpaRepository<Orders, Long>{

}
