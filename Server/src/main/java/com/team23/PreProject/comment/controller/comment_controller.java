package com.team23.PreProject.comment.controller;

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
public class comment_controller {
    @Autowired
    public CommentService commentService;
    @CrossOrigin
    @PostMapping(value = "/api/comment/{uid}")
    public ResponseEntity comment_create(@PathVariable String uid) {
        System.out.println("uid = "+uid+" comment_create" + LocalDate.now() +" "+ LocalTime.now().format(DateTimeFormatter.ofPattern("HH시 mm분 ss초")));
        return new ResponseEntity(commentService.create(uid), HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping(value = "/api/comment/{uid}")
    public ResponseEntity comment_read(@PathVariable String uid) {
        System.out.println("uid = "+uid+" comment_read" + LocalDate.now() +" "+ LocalTime.now().format(DateTimeFormatter.ofPattern("HH시 mm분 ss초")));
        return new ResponseEntity(commentService.read(uid),HttpStatus.OK);
    }
    @CrossOrigin
    @PutMapping(value = "/api/comment/{uid}")
    public ResponseEntity comment_update(@PathVariable String uid) {
        System.out.println("uid = "+uid+" comment_update" + LocalDate.now() +" "+ LocalTime.now().format(DateTimeFormatter.ofPattern("HH시 mm분 ss초")));
        return new ResponseEntity(commentService.update(uid),HttpStatus.OK);
    }
    @CrossOrigin
    @DeleteMapping(value = "/api/comment/{uid}")
    public ResponseEntity comment_delete(@PathVariable String uid) {
        System.out.println("uid = "+uid+" comment_delete" + LocalDate.now() +" "+ LocalTime.now().format(DateTimeFormatter.ofPattern("HH시 mm분 ss초")));
        return new ResponseEntity(commentService.delete(uid),HttpStatus.OK);
    }

}
