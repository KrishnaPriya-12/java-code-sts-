package com.cg.onlineplantnursery.repository;

import java.util.List;



import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.cg.onlineplantnursery.entity.Review;


@Repository
public interface IReviewRepository extends JpaRepository<Review,Integer>{

	


	public List<Review> getReviewsBySeedId(int seedId);

	public List<Review> getReviewsByPlantId(int plantId);
	
	public List<Review> getReviewByPlantId(int plantId);

	public List<Review> getReviewsByPlanterId(int planterId);

	public Review getReviewByCustomerName(String customerName);

	public Review getReviewBystarRating(int starRating);

	public List<Review> getReviewByStarRating(int plantId);

	public List<Review> getReviewsByOrderId(int orderId);



	
	}
