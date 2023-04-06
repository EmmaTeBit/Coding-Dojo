package com.em.travel.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.em.travel.models.Travel;
import com.em.travel.repositories.TravelRepository;

@Service
public class TravelService {
	//access repository:
	private final TravelRepository travelRepo;
	
	public TravelService(TravelRepository travelRepo) {
		this.travelRepo = travelRepo;
	}
	 // returns all the travel
    public List<Travel> allTravels() {
        return travelRepo.findAll();
    }
    // creates 
    public Travel createTravel(Travel travel) {
//    	System.out.println(travel.getAmount());
        return travelRepo.save(travel);
        
    }
    // retrieves 
    public Travel findTravel(Long id) {
        Optional<Travel> optionalTravel = travelRepo.findById(id);
        if(optionalTravel.isPresent()) {
            return optionalTravel.get();
        } else {
            return null;
        }
    }
    public Travel updateTravel(Travel travel) {
        return travelRepo.save(travel);
    }
    public void deleteTravel(Long id) {
    	Optional<Travel> optionalTravel = travelRepo.findById(id);
    	if(optionalTravel.isPresent()) {
    		travelRepo.deleteById(id);
    	}
    }
	
}
