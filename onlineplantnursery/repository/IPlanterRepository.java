package com.cg.onlineplantnursery.repository;



import java.util.List;


import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;


import com.cg.onlineplantnursery.entity.Planter;

public interface IPlanterRepository extends JpaRepositoryImplementation<Planter,Integer>{
	List<Planter> getPlanterByTypesOfPlanters(String typesOfPlanters);

	
	
}
