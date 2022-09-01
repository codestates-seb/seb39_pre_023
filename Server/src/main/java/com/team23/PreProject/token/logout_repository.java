package com.team23.PreProject.token;

import com.team23.PreProject.member_post.entitiy.member_post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface logout_repository extends JpaRepository<logout,Integer> {
    logout findByToken(String token);

    void deleteByToken(String s);
}
