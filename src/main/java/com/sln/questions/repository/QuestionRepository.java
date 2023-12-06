package com.sln.questions.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sln.questions.entities.Questions;

@Repository
public interface QuestionRepository extends JpaRepository<Questions, Integer>{
	
	
	@Query("SELECT q.id FROM Questions q WHERE q.category = :category ORDER BY RAND() LIMIT :noOfQuestions")
	List<Integer> findQuestionIdsByCategoryAndNoOfQuestions(String category, int noOfQuestions);

}