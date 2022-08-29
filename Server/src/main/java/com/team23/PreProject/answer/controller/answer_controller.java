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

    @Autowired
    answer_service answerService;


    @Autowired
    answer_mapper mapper;

    @PostMapping("DBtest/createAnswer/{questionId}")
    public ResponseEntity postanswer(@PathVariable("questionId") Integer questionId,
                                     @RequestBody answer_dto.Post RequestBody) {


        answer answer = mapper.answerPostToanswer(RequestBody);
        Integer memberId = RequestBody.getMemberId();

        answer savedanswer = answerService.createAnswer(questionId, memberId, answer);
        return new ResponseEntity<>(savedanswer.getAnswerId(), HttpStatus.CREATED);
    }

    // 정렬 기준 쿼리파라미터로 받아서 설정하는 기능 추후 추가 예정
    @GetMapping("DBtest/findAnswers/{questionId}")
    public ResponseEntity getanswers(@PathVariable("questionId") Integer questionId, @Positive @RequestParam(defaultValue="1") int page) {
        Page<answer> pageanswers = answerService.findAnswers(questionId, page-1);
        List<answer> answers = pageanswers.getContent();
        return new ResponseEntity<>( new MultiResponseDto(mapper.answersToanswerResponseDto(answers),pageanswers) , HttpStatus.OK);
    }


}

