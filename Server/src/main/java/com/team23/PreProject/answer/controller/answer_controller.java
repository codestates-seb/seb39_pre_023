package com.team23.PreProject.answer.controller;

import com.team23.PreProject.answer.dto.MultiResponseDto;
import com.team23.PreProject.answer.dto.answer_dto;
import com.team23.PreProject.answer.entity.answer;
import com.team23.PreProject.answer.mapper.answer_mapper;
import com.team23.PreProject.answer.service.answer_service;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Positive;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping
public class answer_controller {

    private final answer_service answerService;

    private final answer_mapper mapper;

    @PostMapping("DBtest/createAnswer/{questionId}")
    public ResponseEntity postAnswer(@PathVariable("questionId") Integer questionId,
                                     @RequestBody answer_dto.Post RequestBody) {
        answer answer = mapper.answerPostToAnswer(RequestBody);
        Integer memberId = RequestBody.getMemberId();

        answer savedAnswer = answerService.createAnswer(questionId, memberId, answer);
        return new ResponseEntity<>(savedAnswer.getAnswerId(), HttpStatus.CREATED);
    }

    // 정렬 기준 쿼리파라미터로 받아서 설정하는 기능 추후 추가 예정
    @GetMapping("DBtest/findAnswers/{questionId}")
    public ResponseEntity getAnswers(@PathVariable("questionId") Integer questionId,
                                     @Positive @RequestParam(defaultValue="1") int page) {
        Page<answer> pageAnswers = answerService.findAnswers(questionId, page-1);
        List<answer> answers = pageAnswers.getContent();
        return new ResponseEntity<>( new MultiResponseDto(mapper.answersToAnswerResponseDto(answers),pageAnswers) , HttpStatus.OK);
    }
    @PutMapping("DBtest/updateAnswer/{answerId}")
    public ResponseEntity putAnswer(@PathVariable("answerId") Integer answerId, @RequestBody answer_dto.Post requestBody) {
        String content = requestBody.getContent();
        answer changedAnswer = answerService.updateAnswer(answerId, content);
        answer_dto.Response response = mapper.answerToAnswerResponseDto(changedAnswer);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("DBtest/deleteAnswer/{answerId}")
    public ResponseEntity deleteAnswer(@PathVariable("answerId") Integer answerId){
        answerService.deleteAnswer(answerId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}


