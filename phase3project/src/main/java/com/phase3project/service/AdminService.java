package com.phase3project.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phase3project.entity.Admin;
import com.phase3project.repository.AdminRepository;

@Service
public class AdminService {
	
	@Autowired
	private AdminRepository ar;
	
	public Boolean verifyAdmin(String email, String password){
		List<Admin> admin = ar.findAll();
		for(Admin ad : admin)
		{
			if(ad.getEmail().equals(email) && ad.getPassword().equals(password)) { 
				return true;
			}
		}
		return false;
	}
	
	public void changePassword(int id, String Password){
		Admin ad = ar.findById(id).get();
		ad.setPassword(Password);
		ar.save(ad);
	}

	
}