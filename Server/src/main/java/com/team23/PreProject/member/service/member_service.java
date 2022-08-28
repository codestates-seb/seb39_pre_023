package com.team23.PreProject.member.service;

import com.team23.PreProject.member.dto.member_create_dto;
import com.team23.PreProject.member.entity.member;
import com.team23.PreProject.member.repository.member_repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class member_service {
    @Autowired
    member_repository member_repository;
    public member insert_member(member_create_dto dto){
        member member = new member(dto.getPassword(),dto.getNickName(),dto.getEmail());
        member_repository.save(member);
        return member;

    }

}
