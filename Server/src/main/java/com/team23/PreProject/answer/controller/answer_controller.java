package com.team23.PreProject.answer.controller;

import com.team23.PreProject.Service.AnswerService;
import com.team23.PreProject.Service.CommentService;
import com.team23.PreProject.Service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
public class answer_controller {

    @Autowired
    public AnswerService answerService;

    @CrossOrigin
    @PostMapping(value = "/api/answer/{uid}")
    public ResponseEntity answer_create(@PathVariable String uid) {
        System.out.println("uid = "+uid+" answer_create " + LocalDate.now() +" "+ LocalTime.now().format(DateTimeFormatter.ofPattern("HH시 mm분 ss초")));
        return new ResponseEntity(answerService.create(uid),HttpStatus.OK);
    }
    @CrossOrigin
    @PostMapping(value = "/api/answer/check/{uid}")
    public ResponseEntity answer_checking(@PathVariable String uid) {
        System.out.println("uid = "+uid+" answer_checking" + LocalDate.now() +" "+ LocalTime.now().format(DateTimeFormatter.ofPattern("HH시 mm분 ss초")));
        return new ResponseEntity(answerService.checked(uid),HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping(value = "/api/answer/{uid}")
    public ResponseEntity answer_read(@PathVariable String uid) {
        System.out.println("uid = "+uid+" answer_read" + LocalDate.now() +" "+ LocalTime.now().format(DateTimeFormatter.ofPattern("HH시 mm분 ss초")));
        return new ResponseEntity(answerService.read(uid),HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping(value = "/api/test/answer/{uid}")
    public ResponseEntity answer_read_json_test(@PathVariable String uid) {
        System.out.println("uid = "+uid+" answer_read" + LocalDate.now() +" "+ LocalTime.now().format(DateTimeFormatter.ofPattern("HH시 mm분 ss초")));
        return new ResponseEntity(answerService.read_test(uid),HttpStatus.OK);
    }

    @CrossOrigin
    @PutMapping(value = "/api/answer/{uid}")
    public ResponseEntity answer_update(@PathVariable String uid) {
        System.out.println("uid = "+uid+" answer_update" + LocalDate.now() +" "+ LocalTime.now().format(DateTimeFormatter.ofPattern("HH시 mm분 ss초")));
        return new ResponseEntity(answerService.update(uid),HttpStatus.OK);
    }

    @CrossOrigin
    @DeleteMapping(value = "/api/answer/{uid}")
    public ResponseEntity answer_delete(@PathVariable String uid) {
        System.out.println("uid = "+uid+" answer_delete" + LocalDate.now() +" "+ LocalTime.now().format(DateTimeFormatter.ofPattern("HH시 mm분 ss초")));
        return new ResponseEntity(answerService.delete(uid),HttpStatus.OK);
    }
}
