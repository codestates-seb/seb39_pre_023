package com.team23.PreProject.user.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Entity
@AllArgsConstructor

public class member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer user_id;

    String password;
    String nick_name;
    String email;
    String profile_id;
    String comment_id;
    String answer_id;
    public member(String password, String nick,String email,String pf, String com,String answ)
    {
        this.password = password;
        this.nick_name = nick;
        this.email = email;
        this.profile_id=pf;
        this.comment_id=com;
        this.answer_id = answ;
    }//"password","nick name","email",null,null,null)

}
