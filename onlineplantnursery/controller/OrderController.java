package com.cg.onlineplantnursery.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.onlineplantnursery.dto.CustomerDTO;
import com.cg.onlineplantnursery.dto.OrderAdminResponseDTO;
import com.cg.onlineplantnursery.dto.OrderDTO;
import com.cg.onlineplantnursery.dto.ReviewDTO;
import com.cg.onlineplantnursery.exceptions.CustomerIdNotFoundException;
import com.cg.onlineplantnursery.exceptions.EntityNotFoundException;
import com.cg.onlineplantnursery.exceptions.OrderIdNotFoundException;
import com.cg.onlineplantnursery.entity.Customer;
import com.cg.onlineplantnursery.entity.Order;
import com.cg.onlineplantnursery.entity.Review;
import com.cg.onlineplantnursery.service.IOrderService;
import com.cg.onlineplantnursery.util.OrderDTOConvertor;




@RestController
@RequestMapping("/order")
@CrossOrigin(origins= {"http://localhost:4200","http://localhost:6001"},allowedHeaders="*")
public class OrderController {
	
	@Autowired
	IOrderService orderService;
	
	@Autowired
	OrderDTOConvertor orderDTOConvertor;
	
	
	@PostMapping("/add")
	public ResponseEntity<Order> addOrder(@RequestBody Order cOrder) {

		Order newOrder = orderService.addOrder(cOrder);
		OrderAdminResponseDTO responseDTO = orderDTOConvertor.getOrderAdminResponseDTO(newOrder);

		return new ResponseEntity<Order>(newOrder, HttpStatus.OK);
	}

	@PutMapping("/updateorder/{orderId}")
	
	public String updatedOrder(@PathVariable Integer orderId) throws Exception {
		Order updatedOrder = orderService.viewOrder(orderId);
		return updatedOrder.toString();
		
		}
	@DeleteMapping("/delete/{oid}")
	public ResponseEntity<Order> deleteOrder(@PathVariable Integer oid) throws OrderIdNotFoundException {
       if(oid == null) {
    	   throw new OrderIdNotFoundException("No customer exist with this key");
       }
       else {
		Order deletedOrder = orderService.deleteOrder(oid);

		return new ResponseEntity<Order>(deletedOrder, HttpStatus.OK);
       }
         
	}

	@GetMapping("/view/{oid}")
	public ResponseEntity<Order> viewOrder(@PathVariable Integer oid) throws OrderIdNotFoundException {
      
		Order viewOrder = orderService.viewOrder(oid);

		return new ResponseEntity<Order>(viewOrder, HttpStatus.OK);
	}
	@GetMapping("/orders")
	public ResponseEntity<List<OrderDTO>> viewAllOrders() {
		
		List<Order> allOrders = orderService.viewAllOrders(); // give us raw data (complete information , which we cannot share with users directly)
		// Converting into DTO form , which we can share with user
		List<OrderDTO> allOrderDTO = new ArrayList<>();
		
		for (Order order : allOrders) {
			
			allOrderDTO.add(orderDTOConvertor.getOrderDTO(order));
			
		}
		
		return new ResponseEntity<List<OrderDTO>>(allOrderDTO,HttpStatus.OK);
		
	}
	@GetMapping("/category/{category}")
	public ResponseEntity<List<OrderDTO>> getOrderByCategory(@PathVariable String category) {
		List<Order> allOrderss = orderService.getOrderByCategory(category);
		List<OrderDTO> allOrderDTO = new ArrayList<>();

		for (Order order : allOrderss) {

			allOrderDTO.add(orderDTOConvertor.getOrderDTO(order));

		}

		return new ResponseEntity<List<OrderDTO>>(allOrderDTO, HttpStatus.OK);

	}
	@GetMapping("/searchCategory/{searchCategory}/searchDate/{searchDate}")
	public ResponseEntity<List<OrderDTO>> getOrderByCategoryandDate(String searchCategory, String searchDate){
		List<Order> allOrderss = orderService.getOrderByCategoryandDate(searchCategory,searchDate);
		List<OrderDTO> allOrderDTO = new ArrayList<>();

		for (Order order : allOrderss) {

			allOrderDTO.add(orderDTOConvertor.getOrderDTO(order));

		}

		return new ResponseEntity<List<OrderDTO>>(allOrderDTO, HttpStatus.OK);

	}
	
	/*@GetMapping("/transcation/{transactionMode}")
	public ResponseEntity<List<OrderDTO>> getOrderByTranscation(@PathVariable String transactionMode) {
		List<Order> allOrderss = orderService.getOrderByTranscation(transactionMode);
		List<OrderDTO> allOrderDTO = new ArrayList<>();

		for (Order order : allOrderss) {

			allOrderDTO.add(orderDTOConvertor.getOrderDTO(order));

		}

		return new ResponseEntity<List<OrderDTO>>(allOrderDTO, HttpStatus.OK);

	}*/
	
	

	@GetMapping("/customerid/{customerId}")
	public ResponseEntity<List<OrderDTO>> getOrderByCustomerId(@PathVariable int customerId)
			throws CustomerIdNotFoundException {
		List<Order> allOrderss = orderService.getOrderByCustomerId(customerId);
		if (allOrderss.isEmpty()) {
			throw new CustomerIdNotFoundException("customer id not found"+ customerId);
		} else {
			List<OrderDTO> allOrderDTO = new ArrayList<>();

			for (Order order : allOrderss) {

				allOrderDTO.add(orderDTOConvertor.getOrderDTO(order));

			}

			return new ResponseEntity<List<OrderDTO>>(allOrderDTO, HttpStatus.OK);

		}
	}
	

}