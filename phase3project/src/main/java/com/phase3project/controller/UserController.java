package com.phase3project.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;

import com.phase3project.entity.users;
import com.phase3project.service.UserService;



@RestController
@RequestMapping("/project/user")
public class UserController {
	
	@Autowired
	private UserService us;

	@PostMapping("/userlogin")
	public String userLogin(@RequestBody users u){
		if(us.verifyUser(u.getEmail(), u.getPassword())){
			return "Welcome";
		}
		else{
			return "Invalid";
		}
	}

	@PostMapping("/addUser")
	public ResponseEntity<users> addUser(@RequestBody users u){
		users u1= us.addUser(u);
		if(u1!=null) { 
			return new ResponseEntity<users>(u1,HttpStatus.CREATED);
		}
		else {
			return new ResponseEntity<users>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/allusers")
	public  List<users> getAllUser(){
		return us.getAllUser();
	}

	@GetMapping("/userbyid/{id}")
	public ResponseEntity<users> getUserById(@PathVariable int id){
		  users u= us.getUserById(id);
		  if(u!=null)
			  return new ResponseEntity<users>(u,HttpStatus.FOUND);
		  else
			  return new  ResponseEntity<users>(u,HttpStatus.NOT_FOUND);
	}
	
}