package com.cg.onlineplantnursery.dto;

import lombok.AllArgsConstructor;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SeedDTO {

	private int id;
	private String seedName;
	private String bloomSeason;
	private String typesOfSeeds;
	private int seedsStock;
	private double price;
	private int seedsPerPacket;
	private String image;
	private String about;
	private String discount;
	private int starRating;
}
