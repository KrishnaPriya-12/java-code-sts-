package com.cg.onlineplantnursery.repository;

import java.util.List;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.onlineplantnursery.entity.Seed;

@Repository
public interface ISeedRepository extends JpaRepository<Seed, Integer> {

	List<Seed> getPlantByTypesOfSeeds(String typesOfSeeds);

	List<Seed> getSeedBySeedName(String seedName);

}
