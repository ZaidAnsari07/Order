package com.everpeak.orders.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.everpeak.orders.dto.OrdersDto;
import com.everpeak.orders.entity.Orders;
import com.everpeak.orders.exception.ResourceNotFoundException;
import com.everpeak.orders.repository.OrderRepository;
import com.everpeak.orders.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	OrderRepository orderRepository;

	ModelMapper modelMapper = new ModelMapper();

	@Override
	public List<OrdersDto> getAllOrders() {
		List<Orders> all = orderRepository.findAll();

		List<OrdersDto> ordersDtoList = all.stream().map(this::convertToDto).collect(Collectors.toList());
		
		return ordersDtoList;
	}

	@Override
	public OrdersDto getOrderById(Long orderId) {

		Orders orders = orderRepository.findById(orderId).orElseThrow(() -> new ResourceNotFoundException("Order id does not exist : "+ orderId));;
		
		
		OrdersDto ordersDto = convertToDto(orders);

		return ordersDto;
	}

	@Override
	public OrdersDto createOrder(OrdersDto ordersDto) {

		Orders orders = convertToEntity(ordersDto);
		orders.setItems(ordersDto.getItems());
		orderRepository.saveAndFlush(orders);
		OrdersDto toDto = convertToDto(orders);

		return toDto;
	}

	@Override
	public OrdersDto updateOrderById(OrdersDto ordersDto, Long orderId) {
		Orders orders =orderRepository.findById(orderId).orElseThrow(() -> new ResourceNotFoundException("Order id does not exist : "+ orderId));

		 

		orders.setShippingAddress(ordersDto.getShippingAddress());
		orders.setItems(ordersDto.getItems());

		orderRepository.save(orders);

		OrdersDto dto = convertToDto(orders);
		return dto;
	}

	@Override
	public Boolean deleteOrderById(Long id) {
		orderRepository.deleteById(id);
		return null;
	}

	private OrdersDto convertToDto(Orders orders) {
		return modelMapper.map(orders, OrdersDto.class);
	}

	private Orders convertToEntity(OrdersDto orders) {
		return modelMapper.map(orders, Orders.class);
	}

}
