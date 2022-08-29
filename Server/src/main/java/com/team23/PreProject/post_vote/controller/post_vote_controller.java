package com.team23.PreProject.post_vote.controller;

import com.team23.PreProject.member.repository.member_repository;
import com.team23.PreProject.member.service.member_service;
import com.team23.PreProject.post.repository.post_repository;
import com.team23.PreProject.post.service.post_service;
import com.team23.PreProject.post_vote.entity.post_vote;
import com.team23.PreProject.post_vote.repository.post_vote_repository;
import com.team23.PreProject.post_vote.service.post_vote_service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class post_vote_controller {
    @Autowired
    post_repository post_repository;
    @Autowired
    member_repository member_repository;
    @Autowired
    post_vote_repository post_vote_repository;
    @Autowired
    post_service post_service;
    @Autowired
    member_service member_service;
    @Autowired
    post_vote_service post_vote_service;
    @PostMapping("DBtest/vote")
    public ResponseEntity vote(@RequestParam Integer vote,
                               @RequestParam Integer member_id,
                               @RequestParam Integer post_id)
    {
        String result = post_vote_service.vote(vote,member_id,post_id);


        return new ResponseEntity(result,HttpStatus.OK);
    }//vote
}
