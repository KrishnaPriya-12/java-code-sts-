package com.cg.onlineplantnursery.service;

import java.util.List;



import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.onlineplantnursery.dto.PlantAdminResponseDTO;
import com.cg.onlineplantnursery.exceptions.PlantIdNotFoundException;
import com.cg.onlineplantnursery.entity.Plant;
import com.cg.onlineplantnursery.repository.IPlantRepository;





@Service

public class PlantServiceImpl implements IPlantService{
	
	@Autowired
	private IPlantRepository plantRepo;

	@Override
	@Transactional
	public Plant addPlant(Plant plant)throws PlantIdNotFoundException {
		// TODO Auto-generated method stub
		Plant addPlant = plantRepo.save(plant); 
		if(addPlant!=null) {
			return addPlant;
		}
		else {
			throw new PlantIdNotFoundException("plant details are empty");
		}
			
		
	}

	@Override
	@Transactional
	public Plant updatePlant(int plantId) {
		// TODO Auto-generated method stub
		Plant updatedPlant = plantRepo.getReferenceById(plantId);
		plantRepo.save(updatedPlant);
		return updatedPlant;
	
	}

	@Override
	public Plant deletePlant(Plant plant) throws PlantIdNotFoundException{
		// TODO Auto-generated method stub
		
		Optional<Plant> obj = plantRepo.findById(plant.getPlantId());
		if(obj.isPresent()) {
			plantRepo.delete(plant);
			return plant;
		}
		else {
			throw new PlantIdNotFoundException("This Plant is not present");
		}

	}

	@Override
	public Plant viewPlant(int plantId) throws PlantIdNotFoundException{
		// TODO Auto-generated method stub
		
		Optional<Plant> viewPlant = plantRepo.findById(plantId);
		if(viewPlant.isPresent()) {
			return viewPlant.get();
		}
		else {
			throw new PlantIdNotFoundException("No Plant id found");
		}

	}

	@Override
	public List<Plant> viewPlant(String plantName) throws PlantIdNotFoundException {
		// TODO Auto-generated method stub
		
		List<Plant> plant = plantRepo.findAll();
	
		
		if(plant.size()>0) 
		{
			System.out.println(plant);
			return plant;
		}
		else {
			throw new PlantIdNotFoundException("plant with the given common name is not present");
			
		}
	}

	@Override
	public List<Plant> getAllPlants() throws PlantIdNotFoundException{
		// TODO Auto-generated method stub
		
		List<Plant> plants = plantRepo.findAll();
		if(plants.size()>0) {
			
			return plants;
		}
		else {
			throw new PlantIdNotFoundException("Plant details are empty");
		}
	}

	

//	@Override
//	public List<Plant> getPlantByTypeOfPlant(String typeOfPlant) throws PlantIdNotFoundException {
//		// TODO Auto-generated method stub
//		List<Plant> plants = plantRepo.findAll();
//		if(plants.size()>0)
//		{
//			return plants;
//			
//		}
//		else {
//			throw new PlantIdNotFoundException("Type of plant is not present");
//		}
//
//	}

	@Override
	public PlantAdminResponseDTO getPlantAdminResponseDTO(Plant newPlant) {
		// TODO Auto-generated method stub
		return null;
	}

@Override
public List<Plant> getPlantByTypeOfPlant(String typeOfPlant) throws PlantIdNotFoundException {
	// TODO Auto-generated method stub
	
	List<Plant> obj2 = plantRepo.getPlantByTypeOfPlant(typeOfPlant);
	System.out.println(obj2);
	if (obj2.size() > 0) {
	System.out.println(obj2);
	return obj2;
	} else {
	throw new PlantIdNotFoundException("Type of plant is not present");
	}

}

	
}