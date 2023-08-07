package com.everpeak.orders.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.everpeak.orders.dto.OrderItemsDto;
import com.everpeak.orders.service.OrderItemService;

@RestController
@RequestMapping("/api")
public class OrderItemsCotroller {

	@Autowired
	OrderItemService orderItemsService;

	@PostMapping("/order-items")
	public ResponseEntity<OrderItemsDto> createItem(@RequestBody OrderItemsDto orderItemDto) {
		OrderItemsDto orderItemsDto = orderItemsService.createItems(orderItemDto);
		if (orderItemsDto != null)
			return ResponseEntity.status(HttpStatus.OK).body(orderItemsDto);

		else
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
	}

	@GetMapping("/order-items")
	public ResponseEntity<List<OrderItemsDto>> getAllOrderItems() {
		List<OrderItemsDto> allOrderItems = orderItemsService.getAllOrderItems();
		if (allOrderItems != null)
			return ResponseEntity.status(HttpStatus.FOUND).body(allOrderItems);
		else
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	}

	@GetMapping("/order-items/{id}")
	public ResponseEntity<OrderItemsDto> getOrderItemsById(@PathVariable Long id) {
		OrderItemsDto itemsById = orderItemsService.getOrderItemsById(id);

		if (itemsById != null)
			return ResponseEntity.status(HttpStatus.FOUND).body(itemsById);
		else
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	}

	@PutMapping("/order-items/{id}")
	public ResponseEntity<OrderItemsDto> updateOrderItemsById(@RequestBody OrderItemsDto orderItemDto,
			@PathVariable Long id) {
		OrderItemsDto orderItems = orderItemsService.updateOrderItems(orderItemDto, id);

		if (orderItems != null)
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(orderItems);

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);

	}

	@DeleteMapping("order-items/{id}")
	public ResponseEntity<Boolean> deleteOrderItemsById(@PathVariable Long id){
		Boolean deleteOrderItem = orderItemsService.deleteOrderItem(id);
		

		if(deleteOrderItem)
	return ResponseEntity.status(HttpStatus.OK).body(deleteOrderItem);
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(deleteOrderItem);
		
	}
}
