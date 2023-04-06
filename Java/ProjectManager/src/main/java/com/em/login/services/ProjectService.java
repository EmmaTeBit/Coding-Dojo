package com.em.login.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.em.login.models.Project;
import com.em.login.repositories.ProjectRepository;

@Service
public class ProjectService {

	@Autowired
	private ProjectRepository ProjectRepository;
	
	//find by ID
	public Project findById(Long id) {
		Optional<Project> result = ProjectRepository.findById(id);
		if(result.isPresent()) {
			return result.get();
		}
		return null;
	}
	//findall
	public List<Project> all() {
		return ProjectRepository.findAll();
	}
	//create
	public Project createProject(Project project) {
		return ProjectRepository.save(project);
	}
	//update 
	public Project updateProject(Project project) {
		return ProjectRepository.save(project);
	}
	//delete
	public void deleteProject(Project project) {
		ProjectRepository.delete(project);
		}
	
}
