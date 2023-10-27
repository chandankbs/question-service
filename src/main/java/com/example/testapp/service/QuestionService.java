package com.example.testapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.testapp.model.Questions;
import com.example.testapp.service.repository.QuestionRepository;

@Service
public class QuestionService {
	
	@Autowired
	QuestionRepository questionRepository;

	public List<Questions> getQuestions() {
		return questionRepository.findAll();
	}

	
}
