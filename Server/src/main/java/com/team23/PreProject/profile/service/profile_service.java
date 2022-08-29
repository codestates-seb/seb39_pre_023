package com.team23.PreProject.profile.service;

import com.team23.PreProject.profile.entity.profile;
import com.team23.PreProject.profile.repository.profile_repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class profile_service {
    @Autowired
    profile_repository profile_repository;
    public profile findProfile(Integer member_id) {
        profile profile = profile_repository.findByMemberMemberId(member_id);
        return profile;
    }
}
