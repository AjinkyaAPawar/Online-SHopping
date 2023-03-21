package com.pratiti.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.pratiti.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Integer>{

	@Query("select o from Order o where o.customerId.id = ?1")
	public List<Order> findAllByCustomerId(int customer_id);	
}
