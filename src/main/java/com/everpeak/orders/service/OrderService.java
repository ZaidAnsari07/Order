package com.everpeak.orders.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.everpeak.orders.dto.OrdersDto;

public interface OrderService {

	public List<OrdersDto> getAllOrders();
	
	public OrdersDto getOrderById(Long orderId);
	
	public OrdersDto createOrder(OrdersDto ordersDto);
	
	public OrdersDto updateOrderById(OrdersDto orderDto,Long orderId);
	
	public Boolean deleteOrderById(Long id);
	
}
