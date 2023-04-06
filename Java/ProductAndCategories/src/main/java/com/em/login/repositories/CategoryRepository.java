package com.em.login.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.em.login.models.Category;
import com.em.login.models.Product;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long>{

	List<Category> findAll();
	//find individual Category by ID
//	Category findByIdIs(Long id);
	List<Category> findAllByProducts(Product product);
	List<Category> findByProductsNotContains(Product product);

	
	
}
