package com.team23.PreProject.answer.service;

import com.team23.PreProject.answer.entity.answer;
import com.team23.PreProject.answer.repository.answer_repository;
import com.team23.PreProject.member.entity.member;
import com.team23.PreProject.member.repository.member_repository;
import com.team23.PreProject.post.entity.post;
import com.team23.PreProject.post.repository.post_repository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
@RequiredArgsConstructor
public class answer_service {
    @Autowired
    answer_repository answer_repository;
    @Autowired
    post_repository post_repository;
    @Autowired
    member_repository member_repository;



    public answer createAnswer(Integer postId, Integer memberId, answer answer){
        System.out.println("=========="+memberId);


        post findPost = post_repository.findById(postId).orElseThrow();
        member findMember = member_repository.findById(memberId).orElseThrow();
        findMember.addAnswer(answer);
        answer.setPost(findPost);
        answer.setMember(findMember);
        return answer_repository.save(answer);
    }

    public Page<answer> findAnswers(Integer questionId, int page) {
        post findPost = post_repository.findById(questionId).orElseThrow();
        return answer_repository.findAllByPost(findPost, PageRequest.of(page, 30,
                Sort.by("score").descending()));
    }
}