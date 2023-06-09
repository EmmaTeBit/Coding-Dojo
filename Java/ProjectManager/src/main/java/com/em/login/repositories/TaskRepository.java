package com.em.login.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.em.login.models.Task;

public interface TaskRepository extends CrudRepository<Task, Long> {
	List<Task> findAll();

}
