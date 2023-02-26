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
public class Seed {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
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

	public Seed(int id, String seedName, String bloomSeason, String typesOfSeeds, int seedsStock, double price,
			int seedsPerPacket, String image, String about, String discount, int starRating) {
		super();
		this.id = id;
		this.seedName = seedName;
		this.bloomSeason = bloomSeason;
		this.typesOfSeeds = typesOfSeeds;
		this.seedsStock = seedsStock;
		this.price = price;
		this.seedsPerPacket = seedsPerPacket;
		this.image = image;
		this.about = about;
		this.discount = discount;
		this.starRating = starRating;
	}


	}
