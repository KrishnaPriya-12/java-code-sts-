package com.cg.onlineplantnursery.entity;

import java.time.LocalDate;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@Entity
public class Review {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private int reviewId;
	private String msg;
	private LocalDate orderDate;
	private String customerName; 
	private int starRating;
	private LocalDate reviewDate;
	private int orderId;
	private int plantId;
	private int planterId;
	private int seedId;
	public Review(String msg, String customerName, int starRating,int orderId,
			int plantId, int planterId, int seedId) {
		super();
		this.msg = msg;
		this.customerName = customerName;
		this.starRating = starRating;
		this.orderId=orderId;
		this.plantId = plantId;
		this.planterId = planterId;
		this.seedId = seedId;
		this.reviewDate =LocalDate.now();
		System.out.println("insideOrderEntity"+this);
	}

	
	
}
