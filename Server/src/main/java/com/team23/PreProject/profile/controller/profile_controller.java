package com.team23.PreProject.profile.controller;

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

public class profile_controller {

    @Autowired
    public ProfileService profileService;

    @CrossOrigin
    @PostMapping(value = "/api/users/picture/{uid}")
    public ResponseEntity profile_pic_update(@PathVariable String uid) {
        System.out.println("uid = "+uid+" profile_pic_update" + LocalDate.now() +" "+ LocalTime.now().format(DateTimeFormatter.ofPattern("HH시 mm분 ss초")));
        return new ResponseEntity(profileService.update(uid),HttpStatus.OK);
    }

    @CrossOrigin
    @DeleteMapping(value = "/api/users/picture/{uid}")
    public ResponseEntity profile_pic_delete(@PathVariable String uid) {
        System.out.println("uid = "+uid+" profile_pic_delete" + LocalDate.now() +" "+ LocalTime.now().format(DateTimeFormatter.ofPattern("HH시 mm분 ss초")));
        return new ResponseEntity(profileService.delete(uid),HttpStatus.OK);
    }


}
