package com.everpeak.orders.dto;


import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class OrderItemsDto {
	
	private Long id;
	private String name;
	private String description;
	private double price;
	private int quantity;
	@ManyToOne 
	private OrdersDto order;
	
}
