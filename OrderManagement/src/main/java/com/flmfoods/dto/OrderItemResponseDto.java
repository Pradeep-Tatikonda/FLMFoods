package com.flmfoods.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderItemResponseDto {
	
	private long orderItemId;
	
	private int quantity;
	
	private long itemId;
	

}
