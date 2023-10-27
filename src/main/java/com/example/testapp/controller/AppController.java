package com.example.testapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.testapp.model.Questions;
import com.example.testapp.service.QuestionService;

@RestController
public class AppController {
	
	@Autowired
	QuestionService questionService;
	
	@GetMapping ("/getQuestions")
	public List <Questions> getQuestions() {
		return questionService.getQuestions ();	
	}
}
