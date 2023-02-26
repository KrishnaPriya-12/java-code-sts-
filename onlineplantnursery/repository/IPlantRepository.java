package com.cg.onlineplantnursery.repository;

import java.util.List;


import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

import com.cg.onlineplantnursery.entity.Plant;

@Repository

public interface IPlantRepository extends JpaRepositoryImplementation<Plant,Integer>{
	
	List<Plant> getPlantByTypeOfPlant(String typeOfPlant);

	
	

	
	


}
