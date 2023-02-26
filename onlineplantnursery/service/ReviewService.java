package com.cg.onlineplantnursery.service;

import java.util.List;


import org.springframework.stereotype.Service;

import com.cg.onlineplantnursery.entity.Review;
import com.cg.onlineplantnursery.exceptions.EntityNotFoundException;

@Service
public interface ReviewService {

	public Review registerReview(Review review);

	List<Review> getReviewsBySeedId(int seedId) throws EntityNotFoundException;

	List<Review> getReviewByOrderId(int orderId) throws EntityNotFoundException;

	List<Review> getReviewsByPlantId(int plantId) throws EntityNotFoundException;

	List<Review> getReviewByPlanterId(int planterId) throws EntityNotFoundException;

	public List<Review> getAllReviews();

	Review getReviewByCustomerName(String customerName);

	public Review getReviewBystarRating(int starRating) throws EntityNotFoundException;

	public List<Review> getReviewByStarRating(int planterId);


    public List<Review> getReviewByPlantId(int plantId);

	
	public List<Review> getRatingsByPlantId(int searchplantId, int starRating, String action);




}
