package com.everpeak.orders.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.everpeak.orders.entity.OrderItems;

public interface OrderItemRepository extends JpaRepository<OrderItems, Long>{

}
