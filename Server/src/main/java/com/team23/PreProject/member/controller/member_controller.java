package com.team23.PreProject.member.controller;

import com.team23.PreProject.member.dto.member_create_dto;
import com.team23.PreProject.member.dto.member_password_update_dto;
import com.team23.PreProject.member.entity.member;
import com.team23.PreProject.post.entity.post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class member_controller {
    @Autowired
    com.team23.PreProject.member.service.member_service member_service;
    @PostMapping("DBtest/createMember")
    public ResponseEntity insertMember(@RequestBody member_create_dto member_dto)
    {
        if(member_service.findMemberById(1)==null)
        {
            member member = member_service.insert_member(new member_create_dto("deleted","deleted","deleted"));
        }
        member member = member_service.insert_member(member_dto);

        return new ResponseEntity(member,HttpStatus.CREATED);
    }

    @GetMapping("DBtest/findMember/{member_id}")
    public ResponseEntity findMember(@PathVariable Integer member_id)
    {
//        if(member_id == 1)
//        {
//            return new ResponseEntity("not found",HttpStatus.NOT_FOUND);
//        }
        member member = member_service.findMemberById(member_id);

        if(member!=null)
        return new ResponseEntity(member,HttpStatus.FOUND);
        else
            return new ResponseEntity("not found",HttpStatus.NOT_FOUND);
    }

    @PostMapping("DBtest/updatePassword")
    public ResponseEntity updatePassword(@RequestParam Integer member_id,
                                         @RequestBody member_password_update_dto dto)
    {
        String result = member_service.updatePassword(member_id,dto.getElder(),dto.getNewer());
        if(result.equals("passwored changed"))
            return new ResponseEntity("passwored changed",HttpStatus.OK);
        else
            return new ResponseEntity("passwored not changed",HttpStatus.CONFLICT);
    }//updatePassword end

    @GetMapping("DBtest/createDeletedMember")
    public ResponseEntity createDeletedMember()
    {
        return new ResponseEntity(member_service.createDeltedMember(),HttpStatus.CREATED);
    }//createDeletedMember

    @PostMapping("DBtest/deleteMember")
    public ResponseEntity deleteMember(@RequestParam Integer member_id)
    {
        String result = member_service.deleteMember(member_id);

        if(result.equals("delete suc"))
            return new ResponseEntity(result,HttpStatus.OK);
        else
            return new ResponseEntity(result,HttpStatus.CONFLICT);
    }//deleteMember


}
