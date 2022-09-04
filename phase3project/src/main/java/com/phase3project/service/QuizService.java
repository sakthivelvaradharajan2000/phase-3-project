package com.phase3project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phase3project.entity.Quiz;
import com.phase3project.repository.QuizRepository;

@Service
public class QuizService {
	
	@Autowired
	private QuizRepository qr;
	
	//add method or CREATE RECORD
	public Quiz addUser(Quiz q) {
		return qr.save(q);
	}
	
	
	//List user Method
	public List<Quiz> getAllUser(){
		return qr.findAll();
	}
	
	//get user by id
	public Quiz getUserById(int id) {
		if(qr.findById(id).isPresent()) 
			return qr.findById(id).get();
		else 
			return null;
	
	}
	}