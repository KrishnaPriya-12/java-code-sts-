package com.cg.onlineplantnursery.dto;





import java.time.LocalDate;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReviewDTODefaultResponse {
	
	
	private int id;
	private String customerName;
	private String msg;
	private int plantId;
	private int planterId;
	private int seedId;
	private int starRating;
	private LocalDate reviewDate;
	
}
