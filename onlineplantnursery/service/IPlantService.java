package com.cg.onlineplantnursery.service;

import java.util.List;



import org.springframework.stereotype.Service;

import com.cg.onlineplantnursery.dto.PlantAdminResponseDTO;
import com.cg.onlineplantnursery.exceptions.PlantIdNotFoundException;
import com.cg.onlineplantnursery.entity.Plant;


@Service

public interface IPlantService {
	
	Plant addPlant(Plant plant)throws PlantIdNotFoundException;

	Plant updatePlant(int plantId)throws PlantIdNotFoundException;

	Plant deletePlant(Plant plant)throws PlantIdNotFoundException;

	Plant viewPlant(int plantId)throws PlantIdNotFoundException;

	List<Plant> viewPlant(String plantName)throws PlantIdNotFoundException;

	List<Plant> getAllPlants()throws PlantIdNotFoundException;

	List<Plant> getPlantByTypeOfPlant(String typeOfPlant)throws PlantIdNotFoundException;

	PlantAdminResponseDTO getPlantAdminResponseDTO(Plant newPlant);
	

	

	

	

	

	

}
