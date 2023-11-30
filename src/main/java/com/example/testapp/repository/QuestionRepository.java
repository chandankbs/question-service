package com.example.testapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.testapp.entities.Questions;

@Repository
public interface QuestionRepository extends JpaRepository<Questions, Integer>{
	
}