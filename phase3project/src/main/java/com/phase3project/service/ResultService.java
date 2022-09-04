package com.phase3project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phase3project.entity.Result;
import com.phase3project.repository.ResultRepository;


@Service
public class ResultService {
	
	@Autowired
	private ResultRepository resultrepo;
	
	public List<Result> getAllUser(){
		return resultrepo.findAll();
	}

	public Result getUserById(int id) {
		if(resultrepo.findById(id).isPresent()) 
			return resultrepo.findById(id).get();
		else 
			return null;
		
	}
}