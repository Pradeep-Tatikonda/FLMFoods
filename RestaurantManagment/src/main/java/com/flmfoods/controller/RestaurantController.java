package com.flmfoods.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flmfoods.dto.RestaurantCreationResponse;
import com.flmfoods.dto.RestaurantRequestDto;
import com.flmfoods.dto.RestaurantResponseDto;
import com.flmfoods.service.RestaurantService;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController {
	
	private final RestaurantService restaurantService;
	
	public RestaurantController(RestaurantService restaurantService) {
		this.restaurantService = restaurantService;
	}
	
	@PostMapping("/add")
	public ResponseEntity<RestaurantCreationResponse> addRestaurant(@RequestBody RestaurantRequestDto restaurantRequestDto) {
		RestaurantCreationResponse restaurantCreationResponse = restaurantService.addRestaurant(restaurantRequestDto);
		return ResponseEntity.status(HttpStatus.CREATED).body(restaurantCreationResponse);
	}
	
	@GetMapping("/{restaurantId}")
	public ResponseEntity<RestaurantResponseDto> getRestaurantById(@PathVariable long restaurantId){
		RestaurantResponseDto restaurantById = restaurantService.getRestaurantById(restaurantId);
		return ResponseEntity.ok(restaurantById);
	}
	
	@GetMapping("/name/{restaurantId}")
	public ResponseEntity<String> getRestaurantName(@PathVariable long restaurantId){
		String restaurantName = restaurantService.getRestaurantById(restaurantId).getRestaurantName();
		return ResponseEntity.ok(restaurantName);
	}
	
	

}
