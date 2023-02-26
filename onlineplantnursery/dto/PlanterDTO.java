package com.cg.onlineplantnursery.dto;



import lombok.AllArgsConstructor;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlanterDTO {
	private int id;
	private float planterHeight;
	private int planterCapacity;
	private int drinageHoles;
	private String planterShape;
	private int planterStock;
	private int planterCost;
	private String plantName;
	private int discount;
	private String typesOfPlanters;

}
