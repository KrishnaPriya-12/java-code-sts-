package com.cg.onlineplantnursery.service;

import java.util.List;






import org.springframework.stereotype.Service;

import com.cg.onlineplantnursery.entity.Customer;
import com.cg.onlineplantnursery.entity.Order;
import com.cg.onlineplantnursery.entity.Review;
import com.cg.onlineplantnursery.exceptions.CustomerIdNotFoundException;
import com.cg.onlineplantnursery.exceptions.EntityNotFoundException;
import com.cg.onlineplantnursery.exceptions.InSufficientQuantity;
import com.cg.onlineplantnursery.exceptions.OrderIdNotFoundException;
import com.cg.onlineplantnursery.exceptions.PlantIdNotFoundException;
import com.cg.onlineplantnursery.exceptions.PlanterIdNotFoundException;
import com.cg.onlineplantnursery.exceptions.SeedIdNotFoundException;


@Service
public interface IOrderService {
	public Order addOrder(Order order);
	public Order updateOrder(int orderId) throws OrderIdNotFoundException;
	public Order deleteOrder(int orderId) throws OrderIdNotFoundException;
	public Order viewOrder(int  orderId) throws OrderIdNotFoundException;
	public List<Order> viewAllOrders();
	public List<Order> getOrderByCategory(String category);
	//public List<Order> getOrderByCategoryandDate(String searchCategory, String searchDate);
	
	public List<Order> getOrderByCustomerId(int customerId) throws CustomerIdNotFoundException;
	//public List<Order> getOrderByTranscation(String transactionMode);
	public List<Order> getOrderByCategoryandDate(String category,String searchDate);
	//public List<Order> getOrderByplanterName (String plantName);
	//public Order updatePlanter(int orderId,int planterId);
	

}
