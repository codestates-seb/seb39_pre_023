package com.team23.PreProject.answer_vote.controller;

import com.team23.PreProject.answer_vote.service.answer_vote_service;
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
public class answer_vote_controller {

    @Autowired
    com.team23.PreProject.answer_vote.service.answer_vote_service answer_vote_service;
    @PostMapping("DBtest/answer_vote")
    public ResponseEntity vote(@RequestParam Integer vote,
                               @RequestParam Integer member_id,
                               @RequestParam Integer answer_id)
    {
        String result = answer_vote_service.vote(vote,member_id,answer_id);


        return new ResponseEntity(result,HttpStatus.OK);
    }//vote
}
