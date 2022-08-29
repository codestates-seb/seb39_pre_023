package com.team23.PreProject.post.service;

import com.team23.PreProject.member.entity.member;
import com.team23.PreProject.member.repository.member_repository;
import com.team23.PreProject.member_post.entitiy.member_post;
import com.team23.PreProject.member_post.repository.member_post_repository;
import com.team23.PreProject.post.dto.post_all_dto;
import com.team23.PreProject.post.dto.post_insert_dto;
import com.team23.PreProject.post.dto.post_update_dto;
import com.team23.PreProject.post.entity.post;
import com.team23.PreProject.post.repository.post_repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

@Service

public class post_service {
    @Autowired
   post_repository post_repository;
    @Autowired
    member_repository member_repository;
    @Autowired
    member_post_repository member_post_repository;



    public ResponseEntity insert_test(post_insert_dto test){

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

            return new ResponseEntity(post,HttpStatus.CREATED);

    }

    public post_all_dto findAllPost(int page, int size){
        Pageable pageable = PageRequest.of(page, size, Sort.by("postId").descending());
        Page<post> post_list = post_repository.findAll(pageable);
        Long count = post_repository.count();

        post_all_dto dto = new post_all_dto(post_list,count);
        return dto;
    }

    public Page<post> findPostByMember(int page, int size,Integer member_id){

        //유저 정보 먼저 찾기
        member member = member_repository.findById(member_id).get();
        //
        List<Integer> post_ids = new ArrayList<>();

        for(member_post member_post: member.getMember_posts()){
            post_ids.add(member_post.getPost().getPostId());

        }

        Pageable pageable = PageRequest.of(page, size, Sort.by("postId").descending());
        Page<post> post_list = post_repository.findByPostIdIn(post_ids,pageable);

        return post_list;
    }


    public post updatePost(Integer post_id, post_update_dto dto) {


        try{
            post post = post_repository.findById(post_id).get();

            post.setModified_date(ZonedDateTime.now(ZoneId.of("Asia/Seoul")));
            post.setPost_content(dto.getPost_content());
            post.setPost_name(dto.getPost_name());
            post_repository.save(post);
            return post;
        }catch(Exception e)
        {
            return null;
        }

    }

    public boolean deletePost(Integer post_id){
        boolean result = false;
        try {
            post post = post_repository.findById(post_id).get();

            post_repository.delete(post);
            result = true;
        }catch(Exception e)
        {

        }


        return result;
    }//del end

    public post getPost(Integer post_id)
    {
        try{
            post post = post_repository.findById(post_id).get();
            return post;
        }catch(Exception e){
            return null;
        }

    }//get end

}
