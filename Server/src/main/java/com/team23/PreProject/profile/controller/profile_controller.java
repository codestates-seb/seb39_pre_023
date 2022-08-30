package com.team23.PreProject.profile.controller;

import com.team23.PreProject.profile.dto.profile_update_dto;
import com.team23.PreProject.profile.entity.profile;
import com.team23.PreProject.profile.service.profile_service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
@RestController
public class profile_controller {
    @Autowired
    profile_service profile_service;
    @GetMapping("/DBtest/getProfile")
    public ResponseEntity getMemberProfile(@RequestParam Integer member_id)
    {
        profile profile = profile_service.findProfile(member_id);
        return new ResponseEntity<>(profile,HttpStatus.OK);
    }

    @PutMapping("/DBtest/updateProfile")
    public ResponseEntity updateProfile(@RequestParam Integer profile_id,
                                        @RequestBody profile_update_dto dto){
        if(profile_id==1)
        {
            return new ResponseEntity("you tried to access deleted user",HttpStatus.CONFLICT);
        }
        profile profile = profile_service.update(profile_id,dto);

        return new ResponseEntity(profile,HttpStatus.OK);

    }


}
