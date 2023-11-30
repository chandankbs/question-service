package com.example.testapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.testapp.dto.QuestionsDTO;
import com.example.testapp.entities.Questions;
import com.example.testapp.service.QuestionService;

@RestController
public class AppController {
	
	@Autowired
	QuestionService questionService;
	
	@GetMapping ("/getQuestions")
	public ResponseEntity<List <Questions>> getQuestions() {
		return  new ResponseEntity<>(questionService.getQuestions (), HttpStatus.OK);

	}
	
	@PostMapping ("/createOrUpdateQuestions")
	public ResponseEntity<Questions>  createOrUpdateQuestions(@RequestBody QuestionsDTO questionsDto) {
		Questions questions = new Questions();
		questions.setCategory(questionsDto.getCategory());
		questions.setDifficultyLevel(questionsDto.getDifficultyLevel());
		questions.setOption1(questionsDto.getOption1());
		questions.setOption2(questionsDto.getOption2());
		questions.setOption3(questionsDto.getOption3());
		questions.setOption4(questionsDto.getOption4());
		questions.setQuestionTitle(questionsDto.getQuestionTitle());
		questions.setRightAnswer(questionsDto.getRightAnswer());

		return  new ResponseEntity<>(questionService.createOrUpdateQuestions(questions), HttpStatus.CREATED);
	}
}
