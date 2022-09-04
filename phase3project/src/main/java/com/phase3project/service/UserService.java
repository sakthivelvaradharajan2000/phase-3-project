package com.phase3project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phase3project.entity.users;
import com.phase3project.repository.UserRepository;
import java.util.List;

@Service
public class UserService {
	@Autowired
	private UserRepository ur;
	
	public Boolean verifyUser(String email, String password){
		List<users> user = ur.findAll();
		for(users u : user){
			if(u.getEmail().equals(email) && u.getPassword().equals(password)) { 
				return true;
			}
		}
		return false;
	}
	
	public users addUser(users u) {
		return ur.save(u);
	}

	public List<users> getAllUser(){
		return ur.findAll();
	}

	public users getUserById(int id) {
		if(ur.findById(id).isPresent()) {
			return ur.findById(id).get();
		}
		else {
			return null;
		}
	}
}
