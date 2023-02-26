package com.cg.onlineplantnursery.util;

import org.springframework.stereotype.Component;


import com.cg.onlineplantnursery.dto.PlanterAdminResponseDTO;
import com.cg.onlineplantnursery.dto.PlanterDTO;
import com.cg.onlineplantnursery.entity.Planter;

@Component
public class PlanterDTOConvertor {
	
	public PlanterAdminResponseDTO getPlanterAdminResponseDTO(Planter planter) {
		PlanterAdminResponseDTO dto = new PlanterAdminResponseDTO();
		dto.setId(planter.getPlanterId());
		dto.setPlanterHeight(planter.getPlanterHeight());
		dto.setPlanterCapacity(planter.getPlanterCapacity());
		dto.setDrinageHoles(planter.getDrinageHoles());
		dto.setPlanterShape(planter.getPlanterShape());
		dto.setPlanterStock(planter.getPlanterStock());
		dto.setPlanterCost(planter.getPlanterCost());
		dto.setPlantName(planter.getPlantName());
		dto.setDiscount(planter.getDiscount());
		dto.setTypesOfPlanters(planter.getTypesOfPlanters());
		dto.setMsg("planter saved");
		return dto;

	}

	public PlanterDTO getPlanterDTO(Planter p) {
		PlanterDTO obj = new PlanterDTO(p.getPlanterId(), p.getPlanterHeight(), p.getPlanterCapacity(),
				p.getDrinageHoles(), p.getPlanterShape(), p.getPlanterStock(), p.getPlanterCost(), p.getPlantName(),p.getDiscount(),p.getTypesOfPlanters());
		return obj;
	}


	

	
	
}
