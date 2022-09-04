package com.phase3project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.phase3project.entity.Admin;
import com.phase3project.service.AdminService;

@RestController
@RequestMapping("/project")
public class AdminController {
	
	@Autowired
	private AdminService as;
	
	//http://localhost:8085/project/adminlogin/
	@PostMapping("/adminlogin")
	public String adminLogin(@RequestBody Admin a ){
		if(as.verifyAdmin(a.getEmail(), a.getPassword())){
			return "Welcome";
		}
		else{
			return "Invalid";
		}
	}

	@PostMapping("/adminlogin/changePassword")
	public String changePassword(@RequestBody Admin a ){
		as.changePassword(a.getId(),a.getPassword());
		return "Password Changed";
	}
}