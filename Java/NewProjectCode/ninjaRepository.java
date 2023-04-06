package com.em.dojo.repositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.em.dojo.models.Ninja;

@Repository
public interface ninjaRepository extends CrudRepository<Ninja, Long>{

}
