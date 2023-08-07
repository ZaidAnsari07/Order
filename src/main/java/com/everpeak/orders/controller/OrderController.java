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

import com.everpeak.orders.dto.OrdersDto;
import com.everpeak.orders.service.OrderService;

@RestController
@RequestMapping("/api")
public class OrderController {

	@Autowired
	OrderService orderService;

	@GetMapping("/orders")
	public ResponseEntity<List<OrdersDto>> getAllOrders() {

		List<OrdersDto> allOrders = orderService.getAllOrders();

		return ResponseEntity.status(HttpStatus.OK).body(allOrders);
	}

	@GetMapping("/orders/{id}")
	public ResponseEntity<OrdersDto> getOrderById(@PathVariable Long id) {
		OrdersDto orderById = orderService.getOrderById(id);

		if (orderById != null)
			return ResponseEntity.status(HttpStatus.FOUND).body(orderById);

		else
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	}

	@PostMapping("/orders")
	public ResponseEntity<OrdersDto> createOrder(@RequestBody OrdersDto orderDto) {

		OrdersDto order = orderService.createOrder(orderDto);

		if (order != null) {

			return ResponseEntity.status(HttpStatus.OK).body(order);
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(order);
	}

	@PutMapping("/orders/{id}")
	public ResponseEntity<OrdersDto> updateOrder(@RequestBody OrdersDto orderDto, @PathVariable Long id) {

		OrdersDto ordersDto = orderService.updateOrderById(orderDto,id);

		if (ordersDto != null)
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(orderDto);

		else
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
	}
	
	@DeleteMapping("orders/{id}")
	public ResponseEntity<Boolean> deleteOrderById(@PathVariable Long id) {
		Boolean orderById = orderService.deleteOrderById(id);
	
		if(orderById)
	return ResponseEntity.status(HttpStatus.OK).body(orderById);
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(orderById);
		
	}

}
