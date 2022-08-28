package com.team23.PreProject.comment.repository;

import com.team23.PreProject.comment.entity.comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface comment_repository extends JpaRepository<comment,Integer> {
}
