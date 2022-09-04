package com.phase3project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import com.phase3project.entity.QuizList;
import com.phase3project.service.QuizListService;

@RestController
@RequestMapping("/project/quizlist")
public class QuizListController {
	
	@Autowired
	private QuizListService service;

	@PostMapping("/add")
	public ResponseEntity<QuizList> addUser(@RequestBody QuizList u){
		QuizList user= service.addUser(u);
		if(user!=null)  
			return new ResponseEntity<QuizList>(user,HttpStatus.CREATED);
		else
			return new ResponseEntity<QuizList>(user, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@GetMapping("/getall")
	public  List<QuizList> getAllUser(){
		return service.getAllUser();
	}
}