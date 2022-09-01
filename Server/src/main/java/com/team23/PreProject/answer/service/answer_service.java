package com.team23.PreProject.answer.service;

import com.team23.PreProject.answer.dto.PageInfo;
import com.team23.PreProject.answer.dto.answer_dto;
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

import java.util.ArrayList;
import java.util.List;

@Transactional
@Service
@RequiredArgsConstructor
public class answer_service {
    private final answer_repository answer_repository;
    private final post_repository post_repository;
    private final member_repository member_repository;



    public answer createAnswer(answer_dto.Post RequestBody){
        post post = post_repository.findById(RequestBody.getPostId()).orElseThrow();

        member member = member_repository.findById(RequestBody.getMemberId()).orElseThrow();

        answer answer = new answer();

        answer.setMember(member);
        answer.setPost(post);
        answer.setAnswer_content(RequestBody.getContent());


        answer_repository.save(answer);
        System.out.println("===================save answerend \n\n");


        member.addAnswer(answer);
        member_repository.flush();


        return answer;
    }

    public Page<answer> findAnswers(Integer questionId, int page) {
        post findPost = post_repository.findById(questionId).orElseThrow();
        return answer_repository.findAllByPost(findPost, PageRequest.of(page, 30,
                Sort.by("score").descending()));
    }

    public answer updateAnswer(Integer answerId, String content) {
        answer answer = answer_repository.findById(answerId).orElseThrow();
        answer.setAnswer_content(content);
        return answer;
    }

    public void deleteAnswer(Integer answerId){
        answer_repository.deleteById(answerId);
    }

    public answer_dto.ByMemberDto findAnswersBymember(Integer memberId, int page, int size) {
        member member = member_repository.findById(memberId).get();
        List<answer> member_answer = member.getAnswers();
        List<answer> answers = new ArrayList<>();
        answer ans;
        for(int i = page*size;i<page*size+size;i++)
        {
            if(i>=member_answer.size())
            {
                break;
            }
            ans = member_answer.get(i);
            ans.setPostId(ans.getPost().getPostId());
            answers.add(ans);
        }
        PageInfo pageInfo = new PageInfo(page+1,size,member_answer.size(),member_answer.size()/size);

        answer_dto.ByMemberDto dto = new answer_dto.ByMemberDto(pageInfo,answers);


        return dto;
    }
}
