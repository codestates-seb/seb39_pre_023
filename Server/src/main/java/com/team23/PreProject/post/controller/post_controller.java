package com.team23.PreProject.post.controller;

import com.team23.PreProject.member.entity.member;
import com.team23.PreProject.member.repository.member_repository;
import com.team23.PreProject.member.service.member_service;
import com.team23.PreProject.member_post.entitiy.member_post;
import com.team23.PreProject.member_post.repository.member_post_repository;
import com.team23.PreProject.post.dto.post_insert_dto;
import com.team23.PreProject.post.dto.post_update_dto;
import com.team23.PreProject.post.entity.post;
import com.team23.PreProject.post.service.post_service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@RestController
public class post_controller {
    @Autowired
    post_service post_service;
    @Autowired
    member_repository member_repository;
    @Autowired
    member_post_repository member_post_repository;
    @Autowired
    member_service member_service;
//    @GetMapping("/DBtest")
//    public ResponseEntity test(
//                               @RequestParam(value="member_id", required=false, defaultValue= "1") int member_id,
//                               @RequestParam(value="view_count", required=false, defaultValue= "0") int view_count,
//                               @RequestParam(value="comment_id", required=false, defaultValue= "1") Integer comment_id,
//                               @RequestParam(value="answer_id", required=false, defaultValue= "1") int answer_id,
//                               @RequestParam(value="score", required=false, defaultValue= "0") int score,
//                               @RequestParam(value="post_vote_id", required=false, defaultValue= "1") int post_vote_id,
//                               @RequestParam(value="tag_id", required=false, defaultValue= "0") int tag_id,
//                               @RequestParam(value="post_content", required=false, defaultValue= "post_content") String post_content,
//
//                               @RequestParam(value="write_date",required = false) LocalDateTime write_date,
//                               @RequestParam(value="modified_date",required = false) LocalDateTime modified_date,
//                               @RequestParam(value="is_answered",required = false,defaultValue = "false") boolean is_answered,
//                               @RequestParam(value="post_name",required = false,defaultValue = "post_name") String post_name
//
//                               )
//    {
//
//        write_date = LocalDateTime.now();
//        modified_date = LocalDateTime.now();
//
//        Integer post_id =1;
//
//        post test = post.builder().post_content(post_content).post_name(post_name).post_vote_id(null).answer_id(null).modified_date(modified_date).write_date(write_date).score(0).member_id(member_id).is_answered(false).comment_id(null).view_count(1).answer_id(null).build();
//        post_service.insert_test(test);
//
//        return new ResponseEntity("insert Test!",HttpStatus.CREATED);
//    }

    @GetMapping(value = "/")
    public ResponseEntity comment_read() {
        System.out.println("main page request " + LocalDate.now() +" "+ LocalTime.now().format(DateTimeFormatter.ofPattern("HH시 mm분 ss초")));
        return new ResponseEntity("main page ",HttpStatus.OK);
    }

    @GetMapping("/DBtest/getPost")
    public ResponseEntity getPost(@RequestParam Integer post_id)

    {

        post post = post_service.getPost(post_id);
        if(post==null)
            return new ResponseEntity("not found",HttpStatus.NOT_FOUND);
        return new ResponseEntity(post,HttpStatus.FOUND);
    }

    @PostMapping("/DBtest/post")
    public ResponseEntity post_test(@RequestBody post_insert_dto test)
    {

        post post = post_service.insert_test(test);

        return new ResponseEntity(post,HttpStatus.CREATED);
    }

    @GetMapping("/DBtest/findAllPost")
    public ResponseEntity findAll(@RequestParam(required = false, value = "page", defaultValue = "0") Integer page,
                                  @RequestParam(required = false, value = "size", defaultValue = "15") Integer size){
        System.out.println("find all request");
        Page post_list =post_service.findAllPost(page,size);
        return new ResponseEntity(post_list,HttpStatus.OK);
    }

    @GetMapping("/DBtest/findPost/{user_id}")
    public ResponseEntity findAll(@RequestParam(required = false, value = "page", defaultValue = "0") Integer page,
                                  @RequestParam(required = false, value = "size", defaultValue = "15") Integer size,
                                    @PathVariable Integer user_id)
    {
        System.out.println("find post by user_id "+LocalDateTime.now());
        Page post_list =post_service.findPostByMember(page,size,user_id);
        return new ResponseEntity(post_list,HttpStatus.OK);
    }

    @PutMapping("/DBtest/update/{post_id}")

    public ResponseEntity updatePost(@PathVariable Integer post_id,
                                     @RequestBody post_update_dto dto
                                     )
    {
        System.out.println("update post content "+LocalDateTime.now());
        post post = post_service.updatePost(post_id,dto);
        if(post!=null)
            return new ResponseEntity(post,HttpStatus.OK);
        else
            return new ResponseEntity("error while update post",HttpStatus.CONFLICT);
    }

    @DeleteMapping("/DBtest/delete/{post_id}")
    public ResponseEntity deletePost(@PathVariable Integer post_id                                     )
    {
        System.out.println("deleted post content "+LocalDateTime.now());
        boolean deleted = false;
        deleted = post_service.deletePost(post_id);

        if(deleted)
        {
            return new ResponseEntity("deleted success",HttpStatus.CONFLICT);
        }
        else
        {
            return new ResponseEntity("deleted fail",HttpStatus.CONFLICT);
        }

    }






}
