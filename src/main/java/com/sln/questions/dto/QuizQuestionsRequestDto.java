package com.sln.questions.dto;

import java.util.List;

import lombok.Data;

@Data
public class QuizQuestionsRequestDto {

	private List<Integer> questionIds;
	
}
