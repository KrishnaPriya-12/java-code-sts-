package com.cg.onlineplantnursery.service;

import java.util.List;



import java.util.Optional;
import java.util.function.Supplier;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.graphql.GraphQlProperties.Schema.Printer;
import org.springframework.stereotype.Service;

import com.cg.onlineplantnursery.exceptions.PlanterIdNotFoundException;
import com.cg.onlineplantnursery.entity.Planter;
import com.cg.onlineplantnursery.repository.IPlanterRepository;

@Service
public class PlanterServiceImpl implements IPlanterService {

	@Autowired
	private IPlanterRepository planterRepo;

	@Override
	@Transactional
	public Planter addPlanter(Planter planter) {
		// TODO Auto-generated method stub
		
		Planter addPlanter = planterRepo.save(planter);
		return addPlanter;

	}

	@Override
	@Transactional
	public Planter updatePlanter(int planterId) throws PlanterIdNotFoundException {
		Planter updatedPlanter = planterRepo.getReferenceById(planterId);
		planterRepo.save(updatedPlanter);
		return updatedPlanter;

	}

	@Override
	public Planter viewPlanter(int planterId) throws PlanterIdNotFoundException {
		// TODO Auto-generated method stub

		Optional<Planter> viewPlanter = planterRepo.findById(planterId);
		if (viewPlanter.isPresent()) {
			return viewPlanter.get();
		} else {
			throw new PlanterIdNotFoundException("Planter details List is Empty----------");

		}

	}

	@Override
	public Planter viewPlanterShape(int planterShape) throws PlanterIdNotFoundException {
		// TODO Auto-generated method stub

		Optional<Planter> viewPlanter = planterRepo.findById(planterShape);
		if (viewPlanter.isPresent()) {
			return viewPlanter.get();
		} else {
			throw new PlanterIdNotFoundException("No planter is found");
		}

	}

	@Override
	public List<Planter> viewAllPlanters() throws PlanterIdNotFoundException {
		// TODO Auto-generated method stub
		List<Planter> planters = planterRepo.findAll();
		if (planters.size() > 0) {
			return planters;
		} else {
			throw new PlanterIdNotFoundException("No planter found");

		}
	}

	@Override
	public List<Planter> viewAllPlanters(double minCost, double maxCost) throws PlanterIdNotFoundException {
		// TODO Auto-generated method stub
		List<Planter> planters = planterRepo.findAll();
		if (planters.size() > 0) {
			return planters;
		} else {
			throw new PlanterIdNotFoundException("No planter found");

		}
	}

	@Override
	@Transactional
	public Planter deletePlanter(int planterId) throws PlanterIdNotFoundException {
		
		Planter exsistingPlanter = planterRepo.findById(planterId)
				.orElseThrow(() -> new PlanterIdNotFoundException("Planter is not listed" + planterId));
		planterRepo.delete(exsistingPlanter);
		return exsistingPlanter;

	}

//	@Override
//	public List<Planter> getPlanterByName(String plantName) throws PlanterIdNotFoundException {
//		// TODO Auto-generated method stub
//		List<Planter> obj1 = planterRepo.getPlanterByName(plantName);
//		System.out.println(obj1);
//		if (obj1.size() > 0) {
//		System.out.println(obj1);
//		return obj1;
//		} else {
//		throw new PlanterIdNotFoundException("Planter with the given  name is not present");
//		}
//
//	}

	@Override
	public List<Planter> getPlanterByTypesOfPlanters(String typesOfPlanters) throws PlanterIdNotFoundException {
		// TODO Auto-generated method stub
		List<Planter> obj2 = planterRepo.getPlanterByTypesOfPlanters(typesOfPlanters);
		System.out.println(obj2);
		if (obj2.size() > 0) {
		System.out.println(obj2);
		return obj2;
		} else {
		throw new PlanterIdNotFoundException("Type of planter is not present");
		}
	}



}
