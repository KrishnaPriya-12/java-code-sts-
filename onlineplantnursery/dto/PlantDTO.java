package com.cg.onlineplantnursery.dto;

import java.util.List;




import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class PlantDTO {
	
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

}
