package com.cg.onlineplantnursery.dto;

import java.time.LocalDate;


import com.cg.onlineplantnursery.entity.Planter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO {
	
	private int bookingOrderId;
	private LocalDate orderDate;
	private String transactionMode;
	private int quantity;
	private double totalCost;
	private int customerId;
	private  int productId;
	private String category;

}
