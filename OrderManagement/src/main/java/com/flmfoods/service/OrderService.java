package com.flmfoods.service;

import com.flmfoods.dto.OrderRequestDto;
import com.flmfoods.dto.OrderResponseDto;

public interface OrderService {
	
	public OrderResponseDto placeOrder(OrderRequestDto orderRequest);

}
