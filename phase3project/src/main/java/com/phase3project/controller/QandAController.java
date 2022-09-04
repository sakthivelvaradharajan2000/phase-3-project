package com.phase3project.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import com.phase3project.entity.QandA;
import com.phase3project.service.QandAService;

@RestController
@RequestMapping("/project/questions")
public class QandAController {
	
	@Autowired
	private QandAService qnas;

	@GetMapping("/showall")
	public  List<QandA> getAllUser(){
		return qnas.getAllUser();
	}

	@PostMapping("/add")
	public ResponseEntity<QandA> addUser(@RequestBody QandA u){
		QandA qna= qnas.addUser(u);
		if(qna!=null)  
			return new ResponseEntity<QandA>(qna,HttpStatus.CREATED);
		else
			return new ResponseEntity<QandA>(qna, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@GetMapping("/showone/{id}")
	public ResponseEntity<QandA> getUserById(@PathVariable int id){
		  QandA qa= qnas.getUserById(id);
		  
		  if(qa!=null)
			  return new ResponseEntity<QandA>(qa,HttpStatus.FOUND);
		  else
			  return new  ResponseEntity<QandA>(qa,HttpStatus.NOT_FOUND);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<Object> updateUser(@RequestBody QandA user,@PathVariable int id){
		QandA q= qnas.updateUser(user, id);
		if(q!=null)
			return new ResponseEntity<Object>(q,HttpStatus.OK);
		else
			return new ResponseEntity<Object>("Not Found",HttpStatus.NOT_FOUND);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Object> deleteUser(@PathVariable  int id ){
		
		if(qnas.deleteUser(id))
			return new ResponseEntity<Object>("Deleted", HttpStatus.OK);
		else
			return new ResponseEntity<Object>("Not Found",HttpStatus.NOT_FOUND);
	}
}