package com.em.burger.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.em.burger.models.Burger;
import com.em.burger.repositories.BurgerRepository;

@Service
public class BurgerService {
	//access repository:
	private final BurgerRepository burgerRepo;
	
	public BurgerService(BurgerRepository burgerRepo) {
		this.burgerRepo = burgerRepo;
	}
	 // returns all the burger
    public List<Burger> allBurgers() {
        return burgerRepo.findAll();
    }
    // creates a burger
    public Burger createBurger(Burger burger) {
        return burgerRepo.save(burger);
    }
    // retrieves a burger
    public Burger findBurger(Long id) {
        Optional<Burger> optionalBook = burgerRepo.findById(id);
        if(optionalBook.isPresent()) {
            return optionalBook.get();
        } else {
            return null;
        }
    }
    public Burger updateBurger(Burger burger) {
        return burgerRepo.save(burger);
    }
    public void deleteBurger(Long id) {
    	Optional<Burger> optionalBook = burgerRepo.findById(id);
    	if(optionalBook.isPresent()) {
    		burgerRepo.deleteById(id);
    	}
    }
	
}
