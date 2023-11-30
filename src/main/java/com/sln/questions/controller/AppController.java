package com.sln.questions.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sln.questions.dto.QuestionsDto;
import com.sln.questions.entities.Questions;
import com.sln.questions.service.QuestionService;

@RestController
public class AppController {
	
	@Autowired
	QuestionService questionService;
	
	@GetMapping ("/getQuestions")
	public ResponseEntity<List <Questions>> getQuestions() {
		return  new ResponseEntity<>(questionService.getQuestions (), HttpStatus.OK);

	}
	
	@PostMapping ("/createOrUpdateQuestions")
	public ResponseEntity<Questions>  createOrUpdateQuestions(@RequestBody Questions questions) {
		return  new ResponseEntity<>(questionService.createOrUpdateQuestions(questions), HttpStatus.CREATED);
	}
}
