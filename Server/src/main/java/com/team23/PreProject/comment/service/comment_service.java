package com.team23.PreProject.comment.service;

import com.team23.PreProject.answer.entity.answer;
import com.team23.PreProject.answer.repository.answer_repository;
import com.team23.PreProject.comment.entity.comment;
import com.team23.PreProject.comment.repository.comment_repository;
import com.team23.PreProject.member.entity.member;
import com.team23.PreProject.member.repository.member_repository;
import com.team23.PreProject.post.entity.post;
import com.team23.PreProject.post.repository.post_repository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
@RequiredArgsConstructor
public class comment_service {
    private final comment_repository commentRepository;
    private final post_repository postRepository;
    private final answer_repository answerRepository;
    private final member_repository memberRepository;
    public comment createAnswerComment(Integer answerId, Integer memberId, String content){
        answer findAnswer = answerRepository.findById(answerId).orElseThrow();
        member findMember = memberRepository.findById(memberId).orElseThrow();
        comment comment = new comment(content, findAnswer, findMember);
        return commentRepository.save(comment);
    }

    public comment createPostComment(Integer postId, Integer memberId, String content){
        post findPost = postRepository.findById(postId).orElseThrow();
        member findMember = memberRepository.findById(memberId).orElseThrow();
        comment comment = new comment(content, findPost, findMember);
        return commentRepository.save(comment);
    }

    public List<comment> getAnswerComment(Integer answerId){
        answer findAnswer = answerRepository.findById(answerId).orElseThrow();
        return commentRepository.findAllByAnswer(findAnswer);
    }

    public List<comment> getPostComment(Integer questionId){
        post findPost = postRepository.findById(questionId).orElseThrow();
        return commentRepository.findAllByPost(findPost);
    }

    public comment updateComment(Integer commentId, String content){
        comment comment = commentRepository.findById(commentId).orElseThrow();
        comment.setContent(content);
        comment.setUpdate(true);
        return comment;
    }

    public void deleteComment(Integer commentId){
        commentRepository.deleteById(commentId);
    }
}
