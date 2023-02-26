package com.cg.onlineplantnursery.util;


import org.springframework.stereotype.Component;



import com.cg.onlineplantnursery.dto.ReviewDTO;
import com.cg.onlineplantnursery.dto.ReviewDTODefaultResponse;
import com.cg.onlineplantnursery.entity.Review;





@Component
public class ReviewDTOConvertor {

	public ReviewDTODefaultResponse convertTo(Review review) {
		
		// TODO Auto-generated method stub
		return new ReviewDTODefaultResponse(review.getReviewId(),review.getCustomerName(), review.getMsg(),review.getPlantId(),review.getPlanterId(),review.getSeedId(),review.getStarRating(),review.getReviewDate());
	}

	

	public ReviewDTO getReviewDTO(Review r){
		// TODO Auto-generated method stub
		
	ReviewDTO obj = new ReviewDTO(r.getReviewId(),r.getOrderId(),r.getCustomerName(),r.getMsg(),r.getStarRating());
	
	return obj;
	
}

	}







	
