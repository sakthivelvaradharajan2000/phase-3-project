package com.phase3project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phase3project.entity.QuizList;
import com.phase3project.repository.QuizListRepository;

@Service
public class QuizListService {
	
	@Autowired
	private QuizListRepository qlr;

	public List<QuizList> getAllUser(){
		return qlr.findAll();
	}
	public QuizList addUser(QuizList ql) {
		return qlr.save(ql);
	}

}