package com.team23.PreProject.comment.controller;

import com.team23.PreProject.comment.dto.comment_dto;
import com.team23.PreProject.comment.entity.comment;
import com.team23.PreProject.comment.mapper.comment_mapper;
import com.team23.PreProject.comment.service.comment_service;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/comment")
public class comment_controller {

    private final comment_service commentService;
    private final comment_mapper mapper;


    @PostMapping("/answer")
    public ResponseEntity postAnswerComment(@RequestBody comment_dto.PostAnswer requestBody){
        Integer answerId = requestBody.getAnswerId();
        Integer memberId = requestBody.getMemberId();
        String content = requestBody.getContent();

        if(memberId <= 1 ||memberId == null)
        {
            return new ResponseEntity<>("you tried to access wrong member info", HttpStatus.CREATED);
        }
        comment comment = commentService.createAnswerComment(answerId, memberId, content);
        if(comment == null)
        {
            return new ResponseEntity<>("wrong member info, check login information", HttpStatus.CREATED);
        }
        comment_dto.PostResponse response = mapper.commentToResponse(comment);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PostMapping("/question")
    public ResponseEntity postPostComment(@RequestBody comment_dto.PostPost requestBody){
        Integer postId = requestBody.getPostId();
        Integer memberId = requestBody.getMemberId();
        String content = requestBody.getContent();


        if(memberId <= 1 ||memberId == null)
        {
            return new ResponseEntity<>("you tried to access wrong member info", HttpStatus.CREATED);
        }
        comment comment = commentService.createPostComment(postId, memberId, content);

        if(comment == null)
        {
            return new ResponseEntity<>("wrong member info, check login information", HttpStatus.CREATED);
        }
        comment_dto.PostResponse response = mapper.commentToResponse(comment);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
    @GetMapping("/answer/{answerId}")
    public ResponseEntity getAnswerComments(@PathVariable("answerId") Integer answerId){
        List<comment> comments = commentService.getAnswerComment(answerId);
        List<comment_dto.GetResponse> getResponses = mapper.commentsToResponse(comments);
        return new ResponseEntity<>(getResponses, HttpStatus.OK);
    }

    @GetMapping("/question/{questionId}")
    public ResponseEntity getPostComments(@PathVariable("questionId") Integer questionId){
        List<comment> comments = commentService.getPostComment(questionId);
        List<comment_dto.GetResponse> getResponses = mapper.commentsToResponse(comments);
        return new ResponseEntity<>(getResponses, HttpStatus.OK);
    }

    @PutMapping("/{commentId}")
    public ResponseEntity putComment(@PathVariable("commentId") Integer commentId, @RequestBody comment_dto.Put requestBody){
        String content = requestBody.getContent();
        Integer memberId = requestBody.getMemberId();
        if(memberId <= 1 ||memberId == null)
        {
            return new ResponseEntity<>("you tried to access wrong member info", HttpStatus.CREATED);
        }
        comment comment = commentService.updateComment(commentId, content,memberId);
        comment_dto.PostResponse response = mapper.commentToResponse(comment);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("")
    public ResponseEntity deleteComment(@RequestBody comment_dto.DelRequest requestBody){

        Integer memberId = requestBody.getMemberId();
        if(memberId <= 1 ||memberId == null)
        {
            return new ResponseEntity<>("you tried to access wrong member info", HttpStatus.CREATED);
        }
        boolean result = commentService.deleteComment(requestBody);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
