package com.cg.onlineplantnursery.util;

import org.springframework.stereotype.Component;



import com.cg.onlineplantnursery.dto.PlantAdminResponseDTO;
import com.cg.onlineplantnursery.dto.PlantDTO;
import com.cg.onlineplantnursery.entity.Plant;
@Component

public class PlantDTOConvertor {
	
	public PlantAdminResponseDTO getPlantAdminResponseDTO(Plant plant) 
	{
	
		
		
		PlantAdminResponseDTO dto = new PlantAdminResponseDTO();
		dto.setPlantId(plant.getPlantId());
		dto.setPlantName(plant.getPlantName());
		dto.setHeight(plant.getHeight());
		dto.setTypeOfPlant(plant.getTypeOfPlant());
		dto.setBloomSeason(plant.getBloomSeason());
		dto.setAbout(plant.getAbout());
		dto.setStarRating(plant.getStarRating());
		dto.setDiscount(plant.getDiscount());
		dto.setPrice(plant.getPrice());
		dto.setImageName(plant.getImageName());
		         return dto;
	     }
	public PlantDTO getPlantDTO(Plant p) {
		
	   PlantDTO obj = new PlantDTO(p.getPlantId(),p.getPlantName(),p.getHeight(),p.getTypeOfPlant(),p.getBloomSeason(),p.getAbout(),p.getStarRating(),p.getDiscount(),p.getPrice(),p.getImageName());
	         return obj;
	}




}