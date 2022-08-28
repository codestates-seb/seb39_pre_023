package com.team23.PreProject.post.service;

import com.team23.PreProject.member.entity.member;
import com.team23.PreProject.member.repository.member_repository;
import com.team23.PreProject.member_post.entitiy.member_post;
import com.team23.PreProject.member_post.repository.member_post_repository;
import com.team23.PreProject.post.dto.post_insert_dto;
import com.team23.PreProject.post.entity.post;
import com.team23.PreProject.post.repository.post_repository;

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
    member_repository member_repository;
    @Autowired
    member_post_repository member_post_repository;



    public post insert_test(post_insert_dto test){



            System.out.println("\n\n============================================ json parse");
            System.out.println("test "+test.getPost_content());
            System.out.println("test "+test.getMember_id());
            System.out.println("============================================ json parse end\n\n");
            //post 생성 - 본문, 이름, 유저 정보 저장
            post post= new post();
            post.setPost_content(test.getPost_content());
            post.setPost_name(test.getPost_name());


            //연관된 member 찾아오기
            System.out.println("============================================ find member entity");
            member member = member_repository.findById(test.getMember_id()).get();
            System.out.println("============================================ find member entity end\n\n");
            //연관된 member_post 정보 생성
            member_post member_post = new member_post();
            member_post.setMember(member);
            member_post.setPost(post);

            System.out.println("============================================ save post entity");
            post_repository.save(post);
            System.out.println("============================================ save post entity end\n\n");

            System.out.println("============================================ save member_post entity");
            member_post_repository.save(member_post);
            System.out.println("============================================ save member_post entity end\n\n");

            //연관된 member_post 정보를 post에 저장
            post.addMember_Post(member_post);

            //연관된 member_post 정보를 member에 저장
            member.addMember_Post(member_post);

            //member.setMember_post_id(member_post.getMember_post_id());
            //post.setMember_post_id(member_post.getMember_post_id());
            //member 업데이트
            System.out.println("============================================ update member entity");
            member_repository.save(member);
            System.out.println("============================================ update member entity end\n\n");

            //post 업데이트
            System.out.println("============================================ update post entity");
            post_repository.save(post);
            System.out.println("============================================ update post entity end\n\n");

            return post;

    }

    public Page<post> findAllPost(int page, int size){
        Pageable pageable = PageRequest.of(page, size, Sort.by("postId").descending());
        Page<post> post_list = post_repository.findAll(pageable);

        return post_list;
    }




}
