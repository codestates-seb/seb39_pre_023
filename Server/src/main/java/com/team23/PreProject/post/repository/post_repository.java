package com.team23.PreProject.post.repository;

import com.team23.PreProject.post.entity.post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface post_repository extends JpaRepository<post,Integer> {


}
