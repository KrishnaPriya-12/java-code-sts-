package com.cg.onlineplantnursery.dto;

import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class PlanterAdminResponseDTO {
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

	private String msg;

}