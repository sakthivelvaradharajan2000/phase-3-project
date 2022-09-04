package com.phase3project.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.phase3project.entity.QandA;


@Repository
public interface QandARepository extends JpaRepository<QandA, Integer> {

}