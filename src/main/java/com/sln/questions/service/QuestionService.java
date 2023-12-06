package com.sln.questions.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sln.questions.dto.QuestionsRequestDto;
import com.sln.questions.dto.QuizResponseDto;
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
	
	public List<Integer> generateQuestionForQuiz(QuestionsRequestDto questionsRequestDto) {
		return questionRepository.findQuestionIdsByCategoryAndNoOfQuestions(questionsRequestDto.getCatagory(), questionsRequestDto.getNoOfQuestions());
	}

	public List<Questions> getQuizQuestions(@RequestParam List<Integer> questionIds) {
		List<Questions> questionsList = new ArrayList<Questions> ();
		for (int id:questionIds) {
			questionsList.add(questionRepository.findById(id).get());
		}
		return questionsList;
	}

	public Integer getQuizScore(List<QuizResponseDto> quizResponseList) {
		int score = 0;
		for (QuizResponseDto quizResponseDto: quizResponseList) {
			if (questionRepository.findById(quizResponseDto.getQuestionId()).get().getRightAnswer().equals(quizResponseDto.getSubmittedAnswer())) {
				score++;
			}
		}
		
		return Integer.valueOf(score);
	}
}
