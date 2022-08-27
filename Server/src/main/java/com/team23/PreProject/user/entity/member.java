package com.team23.PreProject.user.entity;

import com.team23.PreProject.answer.entity.answer_entity;
import com.team23.PreProject.comment.entity.comment_entity;
import com.team23.PreProject.post.entity.post;
import com.team23.PreProject.profile.entity.profile;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Entity
@AllArgsConstructor
@Getter
@Setter
public class member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    Integer user_id;

    String password;
    String nick_name;
    String email;
    //String profile_id;
    String comment_id;
    String answer_id;
    public member(String password, String nick,String email,profile pf, String com,String answ)
    {
        this.password = password;
        this.nick_name = nick;
        this.email = email;
        this.profile=pf;
        this.comment_id=com;
        this.answer_id = answ;
    }//"password","nick name","email",null,null,null)

    @OneToMany
    @JoinColumn(name = "PostId")
    List<post> posts = new ArrayList<>();

//    @OneToMany
//    @JoinColumn(name = "comment_id")
//    List<comment_entity> comments = new ArrayList<>();

//    @OneToMany
//    @JoinColumn(name = "answer_id")
//    List<answer_entity> answers = new ArrayList<>();

    @OneToOne
    @JoinColumn(name = "profile_id")
    profile profile;




}
