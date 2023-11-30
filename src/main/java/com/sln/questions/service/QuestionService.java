package com.sln.questions.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sln.questions.entities.Questions;
import com.sln.questions.repository.QuestionRepository;

@Service
public class QuestionService {
	
	@Autowired
	QuestionRepository questionRepository;

	public List<Questions> getQuestions() {
		return questionRepository.findAll();
	}

	public Questions createOrUpdateQuestions(Questions questions) {
		return questionRepository.save(questions);
	}
	
}
