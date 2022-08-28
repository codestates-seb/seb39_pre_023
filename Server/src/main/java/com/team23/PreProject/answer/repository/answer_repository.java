package com.team23.PreProject.answer.repository;

import com.team23.PreProject.answer.entity.answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface answer_repository extends JpaRepository<answer, Integer> {
}
