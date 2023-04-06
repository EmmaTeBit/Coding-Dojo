package com.em.dojo.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.em.dojo.models.Dojo;

@Repository
public interface dojoRepository extends CrudRepository<Dojo, Long>{
	List<Dojo> findAll();

}















————————————
REPOSITORIES ARE INTERFACE
————————————
