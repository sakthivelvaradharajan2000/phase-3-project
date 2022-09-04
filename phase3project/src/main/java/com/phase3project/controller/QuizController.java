package com.phase3project.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.List;

import com.phase3project.entity.Quiz;
import com.phase3project.service.QuizService;

@RestController
@RequestMapping("/project/quiz")
public class QuizController {
	
	@Autowired
	private QuizService service;

	@PostMapping("/addnew")
	public ResponseEntity<Quiz> addUser(@RequestBody Quiz q){
		Quiz quiz= service.addUser(q);
		if(quiz!=null)  
			return new ResponseEntity<Quiz>(quiz,HttpStatus.CREATED);
		else
			return new ResponseEntity<Quiz>(quiz, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@GetMapping("/showquiz")
	public  List<Quiz> getAllUser(){
		return service.getAllUser();
	}

	@GetMapping("/showone/{id}")
	public ResponseEntity<Quiz> getUserById(@PathVariable int id){
		  Quiz q= service.getUserById(id);
		  if(q!=null) {
			  return new ResponseEntity<Quiz>(q,HttpStatus.FOUND);
		  }
		  else {
			  return new  ResponseEntity<Quiz>(q,HttpStatus.NOT_FOUND);
		  }
	}
}