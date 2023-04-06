package com.em.login.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.em.login.models.Tag;

@Repository
public interface TagRepository extends CrudRepository<Tag, Long> {
	Tag findBySubjectIs(String subject);
}
