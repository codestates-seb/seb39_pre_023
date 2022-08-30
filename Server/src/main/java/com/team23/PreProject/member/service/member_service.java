package com.team23.PreProject.member.service;

import com.team23.PreProject.member.dto.member_create_dto;
import com.team23.PreProject.member.entity.member;
import com.team23.PreProject.member.repository.member_repository;
import com.team23.PreProject.member_post.entitiy.member_post;
import com.team23.PreProject.member_post.repository.member_post_repository;
import com.team23.PreProject.post.entity.post;
import com.team23.PreProject.post.repository.post_repository;
import com.team23.PreProject.post_vote.entity.post_vote;
import com.team23.PreProject.post_vote.repository.post_vote_repository;
import com.team23.PreProject.profile.entity.profile;
import com.team23.PreProject.profile.repository.profile_repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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

    @Autowired
    post_vote_repository post_vote_repository;
    @Autowired
    member_post_repository member_post_repository;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    public member insert_member(member_create_dto dto){
        member member = new member(dto.getPassword(),dto.getNickName(),dto.getId());
        member.setPassword(bCryptPasswordEncoder.encode(member.getPassword()));
        profile profile = new profile();
        //멤버 생성
        member = member_repository.save(member);
        //프로필 생성
        //profile.setMember(member);
        profile.setDisplayname(member.getNickName());
        profile = profile_repository.save(profile);
        //멤버 수정
        member.setProfile(profile);
        member.setRoles("ROLE_USER");
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


    public String deleteMember(Integer member_id) {
        if(member_id == 1)
            return "delete fail";
        member member = member_repository.findById(member_id).get();

        member deleted = member_repository.findById(1).get();
        //post vote -> delted 연결
        List<post_vote> post_votes;
        post_votes = member.getPost_votes();

        for(post_vote post_vote : post_votes)
        {
            post_vote.setMember(deleted);
            post_vote_repository.flush();
        }

        System.out.println("================================post vote flush()\n\n");

        //post vote -> delted 연결
//        profile profile;
//        profile = member.getProfile();
//
//
//        profile_repository.delete(profile);
//        System.out.println("================================profile flush()\n\n");




        //List<Integer> post_ids = new ArrayList<>();

        List<member_post> member_posts = member.getMember_posts();
        member.setMember_posts(null);
        for(member_post member_post: member_posts){

            member_post.setMember(deleted);
            member_post_repository.flush();

        }

        deleted.setMember_posts(member_posts);
        System.out.println("================================member_post flush()\n\n");


        member_repository.flush();
        member_repository.delete(member);


        try{
            member = member_repository.findById(member_id).get();
            return "delete fail";
        }catch(Exception e){
            return "delete suc";
        }




    }

    public boolean checkExistId(String id) {
        member member =  member_repository.findByid(id);
        boolean result;
        if(member == null)
        {
            result = false;

        }
        else
            result = true;

        return result;
    }
}
