package com.flmfoods.builder;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.flmfoods.dto.AddressResponseDto;
import com.flmfoods.dto.ItemResponseDto;
import com.flmfoods.dto.RestaurantResponseDto;
import com.flmfoods.model.Address;
import com.flmfoods.model.Item;
import com.flmfoods.model.Restaurant;

@Component
public class RestaurantResponseDtoBuilder {
	
	public RestaurantResponseDto buildRestaurantResponseDto(Restaurant restaurant) {
		return RestaurantResponseDto
			.builder()
			.restaurantId(restaurant.getRestaurantId())
			.restaurantName(restaurant.getRestaurantName())
			.phoneNum(restaurant.getPhoneNum())
			.rating(restaurant.getRating())
			.addressResponseDto(buildAddressResponseDto(restaurant.getAddress()))
			.itemResponseDtoList(buildItemResponseDto(restaurant.getItems()))
			.build();
	}
	
	private static AddressResponseDto buildAddressResponseDto(Address address) {
		AddressResponseDto addressResponseDto = new AddressResponseDto();
		BeanUtils.copyProperties(address, addressResponseDto);
		return addressResponseDto;
	}
	
	private static List<ItemResponseDto> buildItemResponseDto(List<Item> items) {
		List<ItemResponseDto> itemResponseDtoList = new ArrayList<>();
		for (Item item : items) {
			ItemResponseDto itemResponseDto = new ItemResponseDto();
			BeanUtils.copyProperties(item, itemResponseDto);
			itemResponseDtoList.add(itemResponseDto);
		}
		
		return itemResponseDtoList;
	}

}
