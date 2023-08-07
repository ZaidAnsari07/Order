package com.everpeak.orders.service;

import java.util.List;

import com.everpeak.orders.dto.OrderItemsDto;

public interface OrderItemService {

	public OrderItemsDto createItems(OrderItemsDto orderItemsDto);
	
	public OrderItemsDto getOrderItemsById(Long id);

	public List<OrderItemsDto> getAllOrderItems();
	
	public OrderItemsDto updateOrderItems(OrderItemsDto orderItemsDto,Long id);
	
	public Boolean deleteOrderItem(Long id);
	
}
