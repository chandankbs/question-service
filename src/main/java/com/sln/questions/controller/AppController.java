package com.sln.questions.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sln.questions.dto.QuestionsDto;
import com.sln.questions.dto.QuestionsRequestDto;
import com.sln.questions.dto.QuizQuestionsRequestDto;
import com.sln.questions.dto.QuizResponseDto;
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
	
	@PostMapping("/generateQuestionsForQuiz")
	public ResponseEntity<List<Integer>> generateQuestionsForQuiz (@RequestBody QuestionsRequestDto questionsRequestionsRequestDto) {
		System.out.println(questionsRequestionsRequestDto.getCatagory()+"---"+questionsRequestionsRequestDto.getNoOfQuestions());
		return new ResponseEntity<>(questionService.generateQuestionForQuiz(questionsRequestionsRequestDto), HttpStatus.OK);
	}
	
	@PostMapping("/getQuizQuestion")
	public ResponseEntity<List<Questions>> getQuizQuestion (@RequestBody QuizQuestionsRequestDto quizQuestionsRequestDto) {
		System.out.println(quizQuestionsRequestDto.getQuestionIds());
		return new ResponseEntity<>(questionService.getQuizQuestions (quizQuestionsRequestDto.getQuestionIds()), HttpStatus.OK);

	}
	
	@PostMapping("/getQuizScore")
	public ResponseEntity<Integer> getQuizScore (@RequestBody List<QuizResponseDto> quizResponseList) {
		
		return new ResponseEntity<>(questionService.getQuizScore (quizResponseList), HttpStatus.OK);
	}
}
