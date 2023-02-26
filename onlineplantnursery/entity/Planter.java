package com.cg.onlineplantnursery.entity;

import javax.annotation.Generated;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Planter {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int planterId;
	private float planterHeight;
	private int planterCapacity;
	private int drinageHoles;
	private String planterShape;
	private int planterStock;
	private int planterCost;
	private String plantName;
	private String msg;
	private int discount;
	private String typesOfPlanters;



	public Planter(float planterHeight, int planterCapacity, int drinageHoles, String planterShape, int planterStock,
			int planterCost, String plantName, String msg, int discount, String typesOfPlanters) {
		super();
		this.planterHeight = planterHeight;
		this.planterCapacity = planterCapacity;
		this.drinageHoles = drinageHoles;
		this.planterShape = planterShape;
		this.planterStock = planterStock;
		this.planterCost = planterCost;
		this.plantName = plantName;
		this.msg = msg;
		this.discount = discount;
		this.typesOfPlanters = typesOfPlanters;
	}
	
}
