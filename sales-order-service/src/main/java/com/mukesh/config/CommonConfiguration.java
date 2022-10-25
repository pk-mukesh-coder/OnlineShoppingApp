package com.mukesh.config;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.TypeMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mukesh.datamodel.Customer;
import com.mukesh.datamodel.OrderLineItem;
import com.mukesh.dto.OrderLineItemDTO;
import com.mukesh.messagelistener.CustomerMessageListener;

@Configuration
public class CommonConfiguration {
		
	@Bean
	public ModelMapper modelMapper() {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.createTypeMap(OrderLineItem.class, OrderLineItemDTO.class);
		modelMapper.createTypeMap(OrderLineItemDTO.class, OrderLineItem.class);
		TypeMap<com.mukesh.messagelistener.CustomerMessageListener.Customer, Customer> typeMap = modelMapper
				.createTypeMap(com.mukesh.messagelistener.CustomerMessageListener.Customer.class, Customer.class);
		typeMap.addMappings(new PropertyMap<CustomerMessageListener.Customer, Customer>() {

			@Override
			protected void configure() {
				map().setCustEmail(source.getEmail());
				map().setCustId(source.getId());
				map().setCustFirstName(source.getFirstName());
				map().setCustLastName(source.getLastName());
			}
		});
		return modelMapper;
	}
	
}
