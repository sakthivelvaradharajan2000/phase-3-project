package com.phase3project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phase3project.entity.QandA;
import com.phase3project.repository.QandARepository;

@Service
public class QandAService {
	
	@Autowired
	private QandARepository qnar;

	public QandA addUser(QandA u) {
		return qnar.save(u);
	}

	public List<QandA> getAllUser(){
		return qnar.findAll();
	}

	public QandA getUserById(int id) {
		if(qnar.findById(id).isPresent()) {
			return qnar.findById(id).get();
		}
		else {
			return null;
		}
		
	}

	public  QandA updateUser(QandA qna, int id) {
		if(qnar.findById(id).isPresent()){
			QandA q= qnar.findById(id).get();
			q.setOptionA(qna.getOptionA());
			q.setOptionB(qna.getOptionB());
			q.setOptionC(qna.getOptionC());
			q.setOptionD(qna.getOptionD());
			q.setAnswer(qna.getAnswer());
			return qnar.save(q);
		}
		else{
			return null;
		}
		
	}

	public boolean deleteUser(int id) {
		if(qnar.findById(id).isPresent()){
			qnar.deleteById(id);
			return true;
		}
		else {
			return false;
		}
	}
}