package com.flmfoods.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="orders")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Order {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long orderId;
	
	private String status;
	
	private double orderPrice;
	
	private long userId;
	
	private long restaurantId;
	
	@OneToMany(cascade=CascadeType.ALL,mappedBy="order")
	private List<OrderItem> orderItems;

	public Order(String status, double orderPrice, long userId, long restaurantId, List<OrderItem> orderItems) {
		super();
		this.status = status;
		this.orderPrice = orderPrice;
		this.userId = userId;
		this.restaurantId = restaurantId;
		this.orderItems = orderItems;
	}
	
	
	
	
	
}
