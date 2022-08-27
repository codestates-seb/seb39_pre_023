package com.team23.PreProject.post.controller;

import com.team23.PreProject.post.entity.post;
import com.team23.PreProject.post.service.post_service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
public class post_controller {
    @Autowired
    post_service post_service;
//    @GetMapping("/DBtest")
//    public ResponseEntity test(
//                               @RequestParam(value="user_id", required=false, defaultValue= "1") int user_id,
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
//        post test = post.builder().post_content(post_content).post_name(post_name).post_vote_id(null).answer_id(null).modified_date(modified_date).write_date(write_date).score(0).user_id(user_id).is_answered(false).comment_id(null).view_count(1).answer_id(null).build();
//        post_service.insert_test(test);
//
//        return new ResponseEntity("insert Test!",HttpStatus.CREATED);
//    }

    @PostMapping("/DBtest/post")
    public ResponseEntity post_test(@RequestBody post test)
    {

        LocalDateTime write_date = LocalDateTime.now();
        LocalDateTime modified_date = LocalDateTime.now();
        test.setWrite_date(write_date);
        test.setModified_date(modified_date);

        post_service.insert_test(test);

        return new ResponseEntity("insert Test!",HttpStatus.CREATED);
    }

    @GetMapping("/DBtest/findAllPost")
    public ResponseEntity findAll(@RequestParam(required = false, value = "page", defaultValue = "0") Integer page,
                                  @RequestParam(required = false, value = "size", defaultValue = "15") Integer size){
        System.out.println("find all request");
        Page post_list =post_service.findAllPost(page,size);
        return new ResponseEntity(post_list,HttpStatus.OK);
    }

    @GetMapping("/DBtest/insertMember")
    public ResponseEntity init(){
        System.out.println("member inserted");
        post_service.insert_member();
        return new ResponseEntity(HttpStatus.CREATED);
    }




}
