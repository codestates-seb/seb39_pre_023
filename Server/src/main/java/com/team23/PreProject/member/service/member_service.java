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
import com.team23.PreProject.token.logout;
import com.team23.PreProject.token.logout_repository;
import lombok.RequiredArgsConstructor;
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

    @Autowired
    com.team23.PreProject.token.logout_repository logout_repository;

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

    public boolean checkLogout(String token) {
        boolean result = false;

        logout logout = logout_repository.findByToken(token);


        if(logout != null) {
            System.out.println("=================== logout is not null \n\n");
            return true;
        }
        else
        {
            System.out.println("=================== logout null \n\n");
            result = false;
        }

        return result;
    }

    public boolean logout(String token) {
        boolean result = false;//로그아웃 과정이 제대로 수행되어야 true로 변경
        //해당 토큰이 로그아웃 목록에 존재 하는지 확인
        logout logout = logout_repository.findByToken(token);
        if(logout == null)//로그아웃 목록에 없다면 로그아웃 진행
        {
            logout newLogout = new logout();
            newLogout.setToken(token);
            logout_repository.save(newLogout); // 해당 토큰 저장한 logout 객체를 저장
            result =true;
        }
        else//로그아웃 목록에 있다면 로그아웃 진행 X
        {
            result = false;
        }

        return result;
    }

    public void refresh(String token) {

        logout logout = logout_repository.findByToken(token);
        if(logout == null)//로그아웃 목록에 없다면 리다이렉트 정상 진행
        {

        }
        else//로그아웃 목록에 있다면 해당 로그아웃 정보를 삭제
        {
            logout_repository.deleteById(logout.getId()); // 해당 토큰으로 저장된 로그아웃 정보 삭제
        }
        
    }
}
