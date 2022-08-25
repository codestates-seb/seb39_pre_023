package com.team23.PreProject.Controller;

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

@RestController

public class MainController {
    @Autowired
    public AnswerService answerService;

    @Autowired
    public CommentService commentService;

    @Autowired
    public ProfileService profileService;


    @PostMapping(value = "/api/answer/{uid}")
    public ResponseEntity answer_create(@PathVariable String uid) {
        System.out.println("answer_create " + LocalDate.now() +" "+ LocalTime.now().format(DateTimeFormatter.ofPattern("HH시 mm분 ss초")));
        return new ResponseEntity(answerService.create(uid),HttpStatus.OK);
    }
    @PostMapping(value = "/api/answer/check/{uid}")
    public ResponseEntity answer_checking(@PathVariable String uid) {
        System.out.println("answer_checking" + LocalDate.now() +" "+ LocalTime.now().format(DateTimeFormatter.ofPattern("HH시 mm분 ss초")));
        return new ResponseEntity(answerService.checked(uid),HttpStatus.OK);
    }


    @GetMapping(value = "/api/answer/{uid}")
    public ResponseEntity answer_read(@PathVariable String uid) {
        System.out.println("answer_read" + LocalDate.now() +" "+ LocalTime.now().format(DateTimeFormatter.ofPattern("HH시 mm분 ss초")));
        return new ResponseEntity(answerService.read(uid),HttpStatus.OK);
    }


    @PutMapping(value = "/api/answer/{uid}")
    public ResponseEntity answer_update(@PathVariable String uid) {
        System.out.println("answer_update" + LocalDate.now() +" "+ LocalTime.now().format(DateTimeFormatter.ofPattern("HH시 mm분 ss초")));
        return new ResponseEntity(answerService.update(uid),HttpStatus.OK);
    }
    @DeleteMapping(value = "/api/answer/{uid}")
    public ResponseEntity answer_delete(@PathVariable String uid) {
        System.out.println("answer_delete" + LocalDate.now() +" "+ LocalTime.now().format(DateTimeFormatter.ofPattern("HH시 mm분 ss초")));
        return new ResponseEntity(answerService.delete(uid),HttpStatus.OK);
    }
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @PostMapping(value = "/api/comment/{uid}")
    public ResponseEntity comment_create(@PathVariable String uid) {
        System.out.println("comment_create" + LocalDate.now() +" "+ LocalTime.now().format(DateTimeFormatter.ofPattern("HH시 mm분 ss초")));
        return new ResponseEntity(commentService.create(uid),HttpStatus.OK);
    }


    @GetMapping(value = "/api/comment/{uid}")
    public ResponseEntity comment_read(@PathVariable String uid) {
        System.out.println("comment_read" + LocalDate.now() +" "+ LocalTime.now().format(DateTimeFormatter.ofPattern("HH시 mm분 ss초")));
        return new ResponseEntity(commentService.read(uid),HttpStatus.OK);
    }

    @PutMapping(value = "/api/comment/{uid}")
    public ResponseEntity comment_update(@PathVariable String uid) {
        System.out.println("comment_update" + LocalDate.now() +" "+ LocalTime.now().format(DateTimeFormatter.ofPattern("HH시 mm분 ss초")));
        return new ResponseEntity(commentService.update(uid),HttpStatus.OK);
    }

    @DeleteMapping(value = "/api/comment/{uid}")
    public ResponseEntity comment_delete(@PathVariable String uid) {
        System.out.println("comment_delete" + LocalDate.now() +" "+ LocalTime.now().format(DateTimeFormatter.ofPattern("HH시 mm분 ss초")));
        return new ResponseEntity(commentService.delete(uid),HttpStatus.OK);
    }



    @PostMapping(value = "/api/users/picture/{uid}")
    public ResponseEntity profile_pic_update(@PathVariable String uid) {
        System.out.println("profile_pic_update" + LocalDate.now() +" "+ LocalTime.now().format(DateTimeFormatter.ofPattern("HH시 mm분 ss초")));
        return new ResponseEntity(profileService.update(uid),HttpStatus.OK);
    }

    @DeleteMapping(value = "/api/users/picture/{uid}")
    public ResponseEntity profile_pic_delete(@PathVariable String uid) {
        System.out.println("profile_pic_delete" + LocalDate.now() +" "+ LocalTime.now().format(DateTimeFormatter.ofPattern("HH시 mm분 ss초")));
        return new ResponseEntity(profileService.delete(uid),HttpStatus.OK);
    }







}
