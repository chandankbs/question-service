package com.example.testapp.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.testapp.model.Questions;

@Repository
public interface QuestionRepository extends JpaRepository<Questions, Integer>{
	
}