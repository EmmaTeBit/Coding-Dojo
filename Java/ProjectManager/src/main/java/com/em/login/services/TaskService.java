package com.em.login.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.em.login.models.Task;
import com.em.login.repositories.TaskRepository;

@Service
public class TaskService {
	@Autowired
	private TaskRepository TaskRepository;
	
	//find by ID
	public Task findById(Long id) {
		Optional<Task> result = TaskRepository.findById(id);
		if(result.isPresent()) {
			return result.get();
		}
		return null;
	}
	
	//findall
	public List<Task> all() {
		return TaskRepository.findAll();
	}
	//create
	public Task createTask(Task task) {
		return TaskRepository.save(task);
	}
	
}
