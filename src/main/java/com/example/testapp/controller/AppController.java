package com.example.testapp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {
	
	@GetMapping ("/")
	public List<String> getHello() {
		List<String> list = new ArrayList<String>();
		list.add("modi");
		list.add("yogi ji");
		
		return list;
	}
}
