package com.phase3project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.phase3project.entity.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer>{

}