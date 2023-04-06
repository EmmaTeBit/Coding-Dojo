package com.em.login.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.em.login.models.Answer;
import com.em.login.repositories.AnswerRepository;

@Service
public class AnswerService {
	@Autowired
	private AnswerRepository answerRepository;
	
	public List<Answer> questionAnswers(Long questionId) {
		return answerRepository.findByQuestionIdIs(questionId);
	}
	
	public Answer addAnswer(Answer answer) {
		return answerRepository.save(answer);
	}
}
