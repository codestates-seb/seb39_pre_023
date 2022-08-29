package com.team23.PreProject.member.service;

import com.team23.PreProject.member.dto.member_create_dto;
import com.team23.PreProject.member.entity.member;
import com.team23.PreProject.member.repository.member_repository;
import com.team23.PreProject.profile.entity.profile;
import com.team23.PreProject.profile.repository.profile_repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class member_service {
    @Autowired
    member_repository member_repository;
    @Autowired
    profile_repository profile_repository;
    public member insert_member(member_create_dto dto){
        member member = new member(dto.getPassword(),dto.getNickName(),dto.getEmail());
        profile profile = new profile();
        //멤버 생성
        member = member_repository.save(member);
        //프로필 생성
        profile.setMember(member);
        profile.setDisplayname(member.getNickName());
        profile = profile_repository.save(profile);
        //멤버 수정
        member.setProfile(profile);
        //멤버 업데이트
        member_repository.save(member);




        return member;

    }

    public member findMemberById(Integer member_id){
        try {
            member member = member_repository.findById(member_id).get();
            return member;
        }catch (NoSuchElementException e)
        {
            return null;
        }


    }//findMemberById end

    public String updatePassword(Integer member_id, String elder, String newer ){
        member member = member_repository.findById(member_id).get();
        if(member.getPassword().equals(elder)&&!newer.equals(""))
        {
            member.setPassword(newer);
            member_repository.save(member);
            return "passwored changed";
        }
        else
            return "passwored not changed";

    }


}
