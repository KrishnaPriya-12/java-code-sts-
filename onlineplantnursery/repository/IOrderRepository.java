package com.cg.onlineplantnursery.repository;

import java.util.List;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.onlineplantnursery.entity.Order;
@Repository
public interface IOrderRepository extends JpaRepository<Order, Integer>{
	
	public List<Order> getOrderByCategory(String category);

	public List<Order> getOrderByCustomerId(int customerId);
	
	//public List<Order> getOrderByTranscation(String transactionMode);



}
