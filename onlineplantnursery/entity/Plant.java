package com.cg.onlineplantnursery.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor

public class Plant {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int plantId;
	private String plantName; 
	private int height ; 
	private String typeOfPlant;
	private String bloomSeason;
	private String about;
	private int starRating;
	private int discount;
	private int price;
	private String imageName;
	
	public Plant(String plantName,int height, String typeOfPlant, String bloomSeason, String about,int starRating,int discount,int price,String imageName)  
			{
		super();
		this.plantName = plantName;
		this.height = height;
		this.typeOfPlant = typeOfPlant;
		this.bloomSeason = bloomSeason;
		this.about = about;
		this.starRating = starRating;
		this.discount = discount;
		this.price = price;
		this.imageName = imageName;
	}
	


}