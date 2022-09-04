package com.phase3project.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;


import com.phase3project.entity.Result;
import com.phase3project.service.ResultService;



@RestController
@RequestMapping("/project/result")
public class ResultController {
	
	@Autowired
	private ResultService rs;

	@GetMapping("/allresult")
	public  List<Result> getAllUser(){
		return rs.getAllUser();
	}

	@GetMapping("/resultbyid/{id}")
	public ResponseEntity<Result> getUserById(@PathVariable int id){
		 Result r= rs.getUserById(id);
		  
		  if(r!=null) {
			  return new ResponseEntity<Result >(r,HttpStatus.FOUND);
		  }
		  else {
			  return new  ResponseEntity<Result >(r,HttpStatus.NOT_FOUND);
		  }
	}
}
