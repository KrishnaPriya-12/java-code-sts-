package com.cg.onlineplantnursery.controller;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.onlineplantnursery.exceptions.SeedIdNotFoundException;
import com.cg.onlineplantnursery.entity.Seed;
import com.cg.onlineplantnursery.service.SeedServiceImpl;
import com.cg.onlineplantnursery.util.SeedDTOConvertor;
import com.cg.onlineplantnursery.dto.SeedAdminResponseDTO;

@RestController
@RequestMapping("/seed")
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:6001"},allowedHeaders = "*")
public class SeedController {

	@Autowired
	private SeedServiceImpl seedService; 

	@Autowired
	SeedDTOConvertor seedDTO;

	@PostMapping("/add")
	public ResponseEntity<Seed> addSeed(@RequestBody Seed seed)  {
		Seed newSeed = seedService.addSeed(seed);
		SeedAdminResponseDTO responseDTO = seedDTO.getSeedAdminResponseDTO(newSeed);

		return new ResponseEntity<Seed>(newSeed, HttpStatus.OK);
	}

	@PutMapping("/updateseed/{seedId}")
	public String updatedSeed(@PathVariable int seedId) throws SeedIdNotFoundException  {
		Seed updatedSeed = seedService.viewSeed(seedId);
		return updatedSeed.toString();
	}

	@DeleteMapping("/delete/{sId}")
	public ResponseEntity<Seed> deleteSeed(@PathVariable int seedId) throws SeedIdNotFoundException {
		if (seedId == 0) {
			throw new SeedIdNotFoundException("No seed found");
		} else {
			Seed deletedSeed = seedService.deleteSeed(seedId);
			
			return new ResponseEntity<Seed>(deletedSeed, HttpStatus.OK);
		}
	}

	@GetMapping("/view/{sId}")
	public ResponseEntity<Seed> viewSeed(@PathVariable Integer sId) throws SeedIdNotFoundException {
		if (sId == null) {
			throw new SeedIdNotFoundException("Seed Id Not Found");
		} else {
			Seed viewSeed = seedService.viewSeed(sId);
			return new ResponseEntity<Seed>(viewSeed, HttpStatus.OK);
		}
	}

	@GetMapping("/seeds")
	public ResponseEntity<List<Seed>> getAllSeeds() throws SeedIdNotFoundException {
		List<Seed> seeds = this.seedService.getAllSeeds();

		return new ResponseEntity<List<Seed>>(seeds, HttpStatus.OK);

	}

	@GetMapping("/getseeds/{seedName}")
	public ResponseEntity<List<Seed>> getSeedByName(@PathVariable String seedName) throws SeedIdNotFoundException {
		List<Seed> seeds = this.seedService.getSeedBySeedName(seedName);

		return new ResponseEntity<List<Seed>>(seeds, HttpStatus.OK);

	}

	@GetMapping("/showseedslist/{typesofseeds}")
	public ResponseEntity<List<Seed>> getPlantByTypesOfSeeds(@PathVariable String typesofseeds)
			throws SeedIdNotFoundException {
		List<Seed> seeds = this.seedService.getPlantByTypesOfSeeds(typesofseeds);

		return new ResponseEntity<List<Seed>>(seeds, HttpStatus.OK);
	}

}