package com.team23.PreProject.user.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@NoArgsConstructor
@Entity
@AllArgsConstructor

public class user_entity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int user_id;

    String password;
    String nick_name;
    String email;
    String profile_id;
    String comment_id;
    String answer_id;


}
