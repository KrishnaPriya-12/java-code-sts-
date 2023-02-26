package com.cg.onlineplantnursery.controller;

import java.util.ArrayList;



import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;


import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.onlineplantnursery.dto.ReviewDTO;
import com.cg.onlineplantnursery.dto.ReviewDTODefaultResponse;
import com.cg.onlineplantnursery.entity.Review;
import com.cg.onlineplantnursery.exceptions.EntityNotFoundException;
import com.cg.onlineplantnursery.service.ReviewService;
import com.cg.onlineplantnursery.util.ReviewDTOConvertor;




@RestController
@RequestMapping("/nurseryreview")

public class ReviewController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	ReviewService reviewService;

	@Autowired
	ReviewDTOConvertor dtoConvertor;

	public ReviewController() {
		logger.info("Review Controller called");
		System.err.println("Review Controller called");
	}

	@PostMapping("/add")
	//localhost:2224/nurseryreview/add
	public ResponseEntity<ReviewDTODefaultResponse> saveRating(@RequestBody Review review)  {
		Review saveRating = reviewService.registerReview(review);
	
				logger.info(" --->> Student saved " + saveRating);
				ReviewDTODefaultResponse dtoObj = dtoConvertor.convertTo(saveRating);
			

		return new ResponseEntity<ReviewDTODefaultResponse>(dtoObj, HttpStatus.OK);
	}
	@GetMapping("/listOfReviews")
	//localhost:2224/nurseryreview/listOfReviews
	public ResponseEntity<List<ReviewDTO>> getAllReviews()
	{
		List<Review> allReviewsInDB = reviewService.getAllReviews();
		
		List<ReviewDTO> dtoList = new ArrayList<>();
		for (Review review : allReviewsInDB) {
			
			ReviewDTO dtoObj = dtoConvertor.getReviewDTO(review);
			dtoList.add(dtoObj);
		}
		
		return new ResponseEntity<List<ReviewDTO>>(dtoList,HttpStatus.OK);
	}

	@GetMapping("/review/seedId/{seedId}")
	//localhost:2224/nurseryreview/review/seedId/{seedId}
	public ResponseEntity<List<ReviewDTO>>  getReviewsBySeedId( @PathVariable int seedId) throws EntityNotFoundException
	{
		List<Review> allReviewsInDB = reviewService.getReviewsBySeedId(seedId);
		if(allReviewsInDB.isEmpty()) {
			throw new EntityNotFoundException("No order exists with this key" + seedId);
		}
		else {
		List<ReviewDTO> dtoList = new ArrayList<>();
		
		for (Review review : allReviewsInDB) {

			ReviewDTO dtoObj = dtoConvertor.getReviewDTO(review);
			dtoList.add(dtoObj);
		}
		
		return new ResponseEntity<List<ReviewDTO>>(dtoList,HttpStatus.OK);
	}
	}
	@GetMapping("/filtered/{plantId}")
	//localhost:2224/nurseryreview/filtered/review/{plantId}
	public ResponseEntity<List<ReviewDTO>>  getRatingsByPlantId( @PathVariable int plantId,
			@RequestParam String action,@RequestParam int starRating)
	{
		
		List<Review> allReviewsInDB = reviewService.getRatingsByPlantId(plantId,starRating,action);
		List<ReviewDTO> dtoList = new ArrayList<>();
		for (Review review : allReviewsInDB) {
			ReviewDTO dtoObj = dtoConvertor.getReviewDTO(review);
			dtoList.add(dtoObj);
		}
		return new ResponseEntity<List<ReviewDTO>>(dtoList,HttpStatus.OK);
	}
	
	@GetMapping("/review/plantId/{plantId}")
	//localhost:2224/nurseryreview/review/plantId/{plantId}
	public ResponseEntity<List<ReviewDTO>>  getReviewsByPlantId( @PathVariable int plantId) throws EntityNotFoundException {
		
	
		List<Review> allReviewsInDB = reviewService.getReviewsByPlantId(plantId);
		if(allReviewsInDB.isEmpty()) {
			throw new EntityNotFoundException("No Plant exists with this key" + plantId);
		}
		else {
		List<ReviewDTO> dtoList = new ArrayList<>();
		
		for (Review review : allReviewsInDB) {

			ReviewDTO dtoObj = dtoConvertor.getReviewDTO(review);
			dtoList.add(dtoObj);
		}
		
		return new ResponseEntity<List<ReviewDTO>>(dtoList,HttpStatus.OK);
	}
	}
	@GetMapping("/review/orderId/{orderId}")
	//localhost:2224/nurseryreview/review/orderId/{orderId}
	public ResponseEntity<List<ReviewDTO>>  getReviewByOrderId( @PathVariable int orderId) throws EntityNotFoundException {
		
		
		List<Review> allReviewsInDB = reviewService.getReviewByOrderId(orderId);
		if(allReviewsInDB.isEmpty()) {
			throw new EntityNotFoundException("No order exists with this key" + orderId);
		}
		else {
		List<ReviewDTO> dtoList = new ArrayList<>();
		
		for (Review review : allReviewsInDB) {

			ReviewDTO dtoObj = dtoConvertor.getReviewDTO(review);
			dtoList.add(dtoObj);
		}
		
		return new ResponseEntity<List<ReviewDTO>>(dtoList,HttpStatus.OK);
	}
	}
	
	
	@GetMapping("/review/planterId/{planterId}")
	//localhost:2224/nurseryreview/review/planterId/{planterId}
	public ResponseEntity<List<ReviewDTO>>  getReviewsByPlanterId( @PathVariable int planterId) throws EntityNotFoundException {
		
	
		List<Review> allReviewsInDB = reviewService.getReviewByPlanterId(planterId);
		if(allReviewsInDB.isEmpty()) {
			throw new EntityNotFoundException("No planter exists with this key" + planterId);
		}
		else {
		List<ReviewDTO> dtoList = new ArrayList<>();
		
		for (Review review : allReviewsInDB) {

			ReviewDTO dtoObj = dtoConvertor.getReviewDTO(review);
			dtoList.add(dtoObj);
		}
		
		return new ResponseEntity<List<ReviewDTO>>(dtoList,HttpStatus.OK);
	}
	}
	@GetMapping("/reviews/{starRating}")
	//localhost:2224/nurseryreview/reviews/{starRating}
	public ResponseEntity<List<ReviewDTO>> getReviewByStarRating(@PathVariable int starRating) throws EntityNotFoundException {
		if(starRating>5 || starRating<1) {
			throw  new EntityNotFoundException ("please enter valid entry");
		}
		else {
		List<Review> reviewFromDB = reviewService.getReviewByStarRating(starRating);
		List<ReviewDTO> dtoList = new ArrayList<>();
		for (Review review : reviewFromDB) {
			ReviewDTO dtoObj = dtoConvertor.getReviewDTO(review);
			dtoList.add(dtoObj);
		}
	return new ResponseEntity<List<ReviewDTO>>(dtoList,HttpStatus.OK);
	}
	}




	@GetMapping("/review/name/{name}")
	//localhost:2224/nurseryreview/review/name/{name}
	public ResponseEntity<ReviewDTO> getReviewByCustomerName(@PathVariable String name)
	{
		Review reviewFromDB = reviewService.getReviewByCustomerName(name);
		ReviewDTO dto = dtoConvertor.getReviewDTO(reviewFromDB);
	return new ResponseEntity<ReviewDTO>(dto,HttpStatus.OK);
	}
}