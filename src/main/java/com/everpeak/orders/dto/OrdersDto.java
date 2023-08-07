package com.everpeak.orders.dto;

import java.time.LocalDateTime;
import java.util.List;

import com.everpeak.orders.entity.OrderItems;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class OrdersDto {
	
	private Long id;
	private String customerName;
	private String shippingAddress;
	private double totalAmount;
	private String paymentStatus;
	private List<OrderItems> items;
	
	

}
