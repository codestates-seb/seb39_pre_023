package com.team23.PreProject.post.service;

import com.team23.PreProject.post.entity.post;
import com.team23.PreProject.post.repository.post_repository;
import com.team23.PreProject.user.entity.member;
import com.team23.PreProject.user.repository.user_repository;
import org.springframework.beans.factory.annotation.Autowired;
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
//        int user_id;
//
//        String password;
//        String nick_name;
//        String email;
//        String profile_id;
//        String comment_id;
//        String answer_id;

            System.out.println("============================================ post input");


            post_repository.save(test);

    }

    public List<post> findAllPost(){
        return post_repository.findAll();
    }



}
