package com.team23.PreProject.post.service;

import com.team23.PreProject.post.entity.post;
import com.team23.PreProject.post.repository.post_repository;
import com.team23.PreProject.user.entity.member;
import com.team23.PreProject.user.repository.user_repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class post_service {
    @Autowired
   post_repository post_repository;
    @Autowired
    user_repository user_repository;

    public void insert_member(){
        user_repository.save(new member("password","nick name","email",null,null,null));
    }
    public void insert_test(post test){

            System.out.println("============================================ post input");


            post_repository.save(test);

    }

    public Page<post> findAllPost(int page, int size){
        Pageable pageable = PageRequest.of(page, size, Sort.by("postId").descending());//정렬은 객체 속성 기준 - 대소문자 확인
        Page<post> post_list = post_repository.findAll(pageable);

        return post_list;
    }




}
