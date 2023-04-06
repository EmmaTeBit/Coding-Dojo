package com.em.login.services;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.em.login.models.Question;
import com.em.login.repositories.QuestionRepository;

@Service
public class QuestionService {
	@Autowired
	private QuestionRepository questionRepository;
	
	public List<Question> allQuestions(){
		return questionRepository.findAll();
	}
	
	public Question findById(Long id) {
		Optional<Question> optionalQuestion = questionRepository.findById(id);
		if(optionalQuestion.isPresent()) {
			return optionalQuestion.get();
		}else {
			return null;
		}
	}
	
	public Question addQuestion(Question question) {
		return questionRepository.save(question);
	}
}