package com.flmfoods.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flmfoods.model.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long>{

}
