package com.flmfoods.builder;

import com.flmfoods.dto.OrderItemRequestDto;
import com.flmfoods.dto.OrderRequestDto;
import com.flmfoods.model.Order;
import com.flmfoods.model.OrderItem;

import java.util.List;

import org.springframework.beans.BeanUtils;

import java.util.ArrayList;

public class OrderBuilder {
	
	public static Order buildOrderFromOrderDto(OrderRequestDto orderRequestDto) {
		return Order.builder()
				.status("Ordered")
				.orderPrice(orderRequestDto.getOrderPrice())
				.userId(orderRequestDto.getUserId())
				.restaurantId(orderRequestDto.getRestaurantId())
				.orderItems(buildOrderItemListFromDto(orderRequestDto.getOrderItemRequestDtoList())).build();
	}
	
	private static List<OrderItem> buildOrderItemListFromDto(List<OrderItemRequestDto> orderItemRequestDtoList){
		List<OrderItem> orderItemsList = new ArrayList<>();
		
		for (OrderItemRequestDto orderItemRequestDto: orderItemRequestDtoList) {
			OrderItem orderItem = new OrderItem();
			BeanUtils.copyProperties(orderItemRequestDto, orderItem);
			orderItemsList.add(orderItem);
		}
		return orderItemsList;
	}
	
	

}
