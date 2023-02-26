package com.cg.onlineplantnursery.dto;

import lombok.AllArgsConstructor;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class PlantAdminResponseDTO {
	
	private int plantId; 
	private String plantName;
	private int height;
	private String typeOfPlant;
	private String bloomSeason;
	private String about;
	private int starRating;
	private int discount;
	private int price;
	private String imageName;
	private String msg;

}
