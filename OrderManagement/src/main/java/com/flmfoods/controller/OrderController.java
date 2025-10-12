package com.flmfoods.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flmfoods.dto.OrderRequestDto;
import com.flmfoods.dto.OrderResponseDto;
import com.flmfoods.service.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {
	
	private final OrderService orderService;
	
	public OrderController(OrderService orderService) {
		this.orderService = orderService;
	}
	
	@PostMapping
	public OrderResponseDto placeOrder(@RequestBody OrderRequestDto orderRequestDto) {
		return orderService.placeOrder(orderRequestDto);
	}

}
