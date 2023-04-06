package com.em.dojo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.em.dojo.models.Dojo;
import com.em.dojo.models.Ninja;
import com.em.dojo.repositories.dojoRepository;
import com.em.dojo.repositories.ninjaRepository;

@Service
public class AppService {
	
	@Autowired
	private ninjaRepository nRepo;
	@Autowired
	private dojoRepository dRepo;
	
	//method: Get all Dojos 
	public List<Dojo> allDojos(){
		return this.dRepo.findAll();
	}
	//method: create new Dojos and Ninjas
	public Dojo createDojo(Dojo dojo) {
		return this.dRepo.save(dojo);
	}
	public Ninja createNinja(Ninja ninja) {
		return this.nRepo.save(ninja);
	}
	//fetch one dojo
	public Dojo getOneDojo(Long id) {
		return this.dRepo.findById(id).orElse(null);
	}
	
	
	
	
	
	
	
	
	
}

/