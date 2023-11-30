package com.sln.questions.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sln.questions.entities.Questions;

@Repository
public interface QuestionRepository extends JpaRepository<Questions, Integer>{
	
}