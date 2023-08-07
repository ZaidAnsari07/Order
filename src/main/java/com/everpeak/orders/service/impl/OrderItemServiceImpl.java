package com.everpeak.orders.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.everpeak.orders.dto.OrderItemsDto;
import com.everpeak.orders.dto.OrdersDto;
import com.everpeak.orders.entity.OrderItems;
import com.everpeak.orders.entity.Orders;
import com.everpeak.orders.exception.ResourceNotFoundException;
import com.everpeak.orders.repository.OrderItemRepository;
import com.everpeak.orders.service.OrderItemService;

@Service
public class OrderItemServiceImpl implements OrderItemService{

	@Autowired
	OrderItemRepository orderItemrepository;
	

	ModelMapper modelMapper=new ModelMapper();
	
	@Override
	public OrderItemsDto createItems(OrderItemsDto orderItemsDto) {
		OrderItems orderItems = convertToEntity(orderItemsDto);
		
		OrderItems save = orderItemrepository.save(orderItems);
		
		return convertToDto(save);
	}

	@Override
	public OrderItemsDto getOrderItemsById(Long id) {
		OrderItems orderItems = orderItemrepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("OrderItems id does not exist : "+ id));
		
		return convertToDto(orderItems);
	}

	@Override
	public List<OrderItemsDto> getAllOrderItems() {
		List<OrderItems> all = orderItemrepository.findAll();
		
		List<OrderItemsDto> collect = all.stream().map(this::convertToDto).collect(Collectors.toList());
		
		return collect;
	}

	@Override
	public OrderItemsDto updateOrderItems(OrderItemsDto orderItemsDto,Long id) {
		OrderItems items = orderItemrepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("OrderItems id does not exist : "+ id));
		
		items.setDescription(orderItemsDto.getDescription());
		items.setName(orderItemsDto.getName());
		items.setPrice(orderItemsDto.getPrice());
		items.setQuantity(orderItemsDto.getQuantity());
		OrderItems save = orderItemrepository.save(items);
		return convertToDto(save);
	}

	@Override
	public Boolean deleteOrderItem(Long id) {
		

		orderItemrepository.deleteById(id);
		
		return true;
	}

	private OrderItemsDto convertToDto(OrderItems orders) {
		return modelMapper.map(orders, OrderItemsDto.class);
	}

	private OrderItems convertToEntity(OrderItemsDto orders) {
		return modelMapper.map(orders, OrderItems.class);
	}
	
}
