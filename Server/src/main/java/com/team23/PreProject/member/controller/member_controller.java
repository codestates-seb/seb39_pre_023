package com.team23.PreProject.member.controller;

import com.team23.PreProject.member.dto.member_create_dto;
import com.team23.PreProject.member.entity.member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class member_controller {
    @Autowired
    com.team23.PreProject.member.service.member_service member_service;
    @PostMapping("DBtest/createMember")
    public ResponseEntity insertMember(@RequestBody member_create_dto member_dto)
    {
        member member = member_service.insert_member(member_dto);

        return new ResponseEntity(member,HttpStatus.CREATED);
    }

    @GetMapping("DBtest/findMember/{member_id}")
    public ResponseEntity findMember(@PathVariable Integer member_id)
    {
        member member = member_service.findMemberById(member_id);

        if(member!=null)
        return new ResponseEntity(member,HttpStatus.FOUND);
        else
            return new ResponseEntity("not found",HttpStatus.NOT_FOUND);
    }


}
