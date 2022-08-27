package com.team23.PreProject.user.repository;

import com.team23.PreProject.user.entity.member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface user_repository extends JpaRepository<member,Integer> {
}
