package com.cg.onlineplantnursery.repository;

import com.cg.onlineplantnursery.entity.Order;
import com.cg.onlineplantnursery.entity.Planter;

public interface ICustomOrderRepository {

	public Order updateOrderByPlanter(Order order,
			Planter planter);
}
