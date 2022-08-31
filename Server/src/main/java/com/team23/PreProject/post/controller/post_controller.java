package com.team23.PreProject.post.controller;

import com.team23.PreProject.member.entity.member;
import com.team23.PreProject.member.repository.member_repository;
import com.team23.PreProject.member.service.member_service;
import com.team23.PreProject.member_post.entitiy.member_post;
import com.team23.PreProject.member_post.repository.member_post_repository;
import com.team23.PreProject.post.dto.*;
import com.team23.PreProject.post.entity.post;
import com.team23.PreProject.post.service.post_service;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class post_controller {
    private final post_service post_service;
    private final member_repository member_repository;
    private final member_post_repository member_post_repository;
    private final member_service member_service;

    @GetMapping(value = "/")
    public ResponseEntity comment_read() {
        System.out.println("main page request " + LocalDate.now() +" "+ LocalTime.now().format(DateTimeFormatter.ofPattern("HH시 mm분 ss초")));
        return new ResponseEntity("main page ",HttpStatus.OK);
    }

    @GetMapping("/DBtest/getPost")
    public ResponseEntity getPost(@RequestParam Integer post_id)

    {

        post_profile_dto dto = post_service.getPost(post_id);
        if(dto==null)
            return new ResponseEntity("not found",HttpStatus.NOT_FOUND);
        return new ResponseEntity(dto,HttpStatus.FOUND);
    }

    @PostMapping("/DBtest/post")
    public ResponseEntity post_test(@RequestBody post_insert_dto test)
    {
        if(test.getMember_id() == 1)
            return new ResponseEntity("you tried to access deleted user", HttpStatus.CONFLICT);
        post post = post_service.insert_test(test);

        post_create_dto dto = new post_create_dto(post.getPostId(),post.getPost_content(),post.getPost_content(),post.getWrite_date(),post.getModified_date());
        System.out.println("dto created");
        return new ResponseEntity(dto,HttpStatus.CREATED);
    }

    @GetMapping("/DBtest/findAllPost")
    public ResponseEntity findAll(@RequestParam(required = false, value = "page", defaultValue = "0") Integer page,
                                  @RequestParam(required = false, value = "size", defaultValue = "15") Integer size){
        System.out.println("find all request");
        post_all_dto post_list =post_service.findAllPost(page,size);


        return new ResponseEntity(post_list,HttpStatus.OK);
    }

    @GetMapping("/DBtest/findPost/{member_id}")
    public ResponseEntity findAll(@RequestParam(required = false, value = "page", defaultValue = "0") Integer page,
                                  @RequestParam(required = false, value = "size", defaultValue = "15") Integer size,
                                    @PathVariable Integer member_id)
    {

        if(member_id == 1)
            return new ResponseEntity("you tried to access deleted user", HttpStatus.CONFLICT);

        System.out.println("find post by user_id "+ ZonedDateTime.now(ZoneId.of("Asia/Seoul")));
        Page post_list =post_service.findPostByMember(page,size,member_id);
        return new ResponseEntity(post_list,HttpStatus.OK);
    }

    @PutMapping("/DBtest/update/{post_id}")

    public ResponseEntity updatePost(@PathVariable Integer post_id,
                                     @RequestBody post_update_dto dto
                                     )
    {
        if(member_post_repository.findByPostPostId(post_id).getMember().getMemberId()==1)
            return new ResponseEntity("you tried access deleted user",HttpStatus.CONFLICT);

        System.out.println("update post content "+ZonedDateTime.now(ZoneId.of("Asia/Seoul")));
        post post = post_service.updatePost(post_id,dto);
        if(post!=null)
            return new ResponseEntity(post,HttpStatus.OK);
        else
            return new ResponseEntity("error while update post",HttpStatus.CONFLICT);
    }

    @DeleteMapping("/DBtest/delete/{post_id}")
    public ResponseEntity deletePost(@PathVariable Integer post_id                                     )
    {
        if(member_post_repository.findByPostPostId(post_id).getMember().getMemberId()==1)
            return new ResponseEntity("you tried access deleted user",HttpStatus.CONFLICT);

        System.out.println("deleted post content "+ZonedDateTime.now(ZoneId.of("Asia/Seoul")));
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
