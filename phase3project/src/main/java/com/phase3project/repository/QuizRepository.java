package com.phase3project.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.phase3project.entity.Quiz;

@Repository
public interface QuizRepository extends JpaRepository<Quiz, Integer> {

}
