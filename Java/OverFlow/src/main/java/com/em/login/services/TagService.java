package com.em.login.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.em.login.models.Tag;
import com.em.login.repositories.TagRepository;

@Service
public class TagService {
	@Autowired
	private TagRepository tagRepository;
	
	public Tag findBySubject(String subject) {
		return tagRepository.findBySubjectIs(subject);
	}
	
	public Tag addTag(Tag tag) {
		return tagRepository.save(tag);
	}
}