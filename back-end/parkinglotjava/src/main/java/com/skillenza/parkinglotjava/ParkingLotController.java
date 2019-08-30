package com.skillenza.parkinglotjava;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import com.skillenza.parkinglotjava.ParkingLot;
import com.skillenza.parkinglotjava.ParkingLotRepository;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/api")
public class ParkingLotController {
	
	@Autowired
	private ParkingLotRepository repo;

	@GetMapping(value="/parkings", produces="application/json")
    public List<ParkingLot> getData() {
    	return getRepoData();
    }
	
	@PostMapping(value="/parkings", consumes="application/json")
	public void postDate(ParkingLot data) {
		saveDate(data);
	}
	
	List<ParkingLot> getRepoData() {
		return repo.findAll();
	}
	
	ParkingLot saveDate(ParkingLot data) {
		repo.save(data);
	}
	}
}

