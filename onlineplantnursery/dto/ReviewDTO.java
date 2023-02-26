package com.cg.onlineplantnursery.dto;


import lombok.AllArgsConstructor;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class ReviewDTO {
	private int Id;
	private int orderId;
	private String customerName;
	private String msg;
	private int starRating;
}
