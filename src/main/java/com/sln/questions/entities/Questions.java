package com.sln.questions.entities;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Questions implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue (strategy = GenerationType.SEQUENCE)
	private Integer id;
	
	//@Column(name = "questionTitle")
	private String questionTitle;
	
	//@Column(name = "option1")
	private String option1;
	
	//@Column(name = "option2")
	private String option2;
	
	//@Column(name = "option3")
	private String option3;
	
	//@Column(name = "option4")
	private String option4;
	
	//@Column(name = "rightAnswer")
	private String rightAnswer;
	
	//@Column(name = "difficultyLevel")
	private String difficultyLevel;
	
	//@Column(name = "category")
	private String category;
	
}
