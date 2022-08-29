package com.team23.PreProject.member.service;

import com.team23.PreProject.member.dto.member_create_dto;
import com.team23.PreProject.member.entity.member;
import com.team23.PreProject.member.repository.member_repository;
import com.team23.PreProject.member_post.entitiy.member_post;
import com.team23.PreProject.post.entity.post;
import com.team23.PreProject.post.repository.post_repository;
import com.team23.PreProject.profile.entity.profile;
import com.team23.PreProject.profile.repository.profile_repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class member_service {
    @Autowired
    member_repository member_repository;
    @Autowired
    profile_repository profile_repository;

    @Autowired
    post_repository post_repository;
    public member insert_member(member_create_dto dto){
        member member = new member(dto.getPassword(),dto.getNickName(),dto.getId());
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

    }//updatePassword

    public member createdeletedMember(){
        member member = new member();
        member.setMemberId(0);
        member.setNickName("deleted");
        member.setPassword("deleted");
        member.setId("deleted");
        member = member_repository.save(member);
        return member;
    }


    public String deleteMember(Integer member_id) {
        if(member_id == 1)
            return "delete fail";
        member member = member_repository.findById(member_id).get();

        member_repository.delete(member);

        List<Integer> post_ids = new ArrayList<>();
        member deleted = member_repository.findById(1).get();
        List<member_post> member_posts = member.getMember_posts();

        for(member_post member_post: member_posts){

            member_post.setMember(deleted);

        }

        deleted.setMember_posts(member_posts);
        member_repository.save(deleted);


        try{
            member = member_repository.findById(member_id).get();
            return "delete fail";
        }catch(Exception e){
            return "delete suc";
        }




    }
}
