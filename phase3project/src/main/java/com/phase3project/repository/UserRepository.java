package com.phase3project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.phase3project.entity.users;

@Repository
public interface UserRepository extends JpaRepository<users, Integer> {

}