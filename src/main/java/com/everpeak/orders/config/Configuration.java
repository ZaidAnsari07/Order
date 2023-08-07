package com.everpeak.orders.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;


public class Configuration {

	
	@Bean
	private ModelMapper modelMapper() {
		return new ModelMapper();
	}
	
}
