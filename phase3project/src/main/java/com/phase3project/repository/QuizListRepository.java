package com.phase3project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.phase3project.entity.QuizList;

@Repository
public interface QuizListRepository extends JpaRepository<QuizList, Integer> {

}