package com.team23.PreProject.member.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.team23.PreProject.member_post.entitiy.member_post;
import com.team23.PreProject.profile.entity.profile;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Entity
@AllArgsConstructor
@Getter
@Setter
@Table(name="MEMBER")


public class member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MEMBER_ID",nullable = false)
    Integer memberId;
    @Column(name = "sign_in_date")
    LocalDateTime signInDate=LocalDateTime.now();
    @Column(name = "PASSWORD")
    String Password;
    @Column(name = "NICKNAME")
    String NickName;
    @Column(name = "EMAIL")
    String Email;
    //String profile_id;
    @Column(name = "COMMENT_ID")
    String comment_id;
    @Column(name = "ANSWER_ID")
    String answer_id;
//    @Column(name = "MEMBER_POST_ID")
//    Integer member_post_id;
    public member(String Password, String nick,String Email,profile pf, String com,String answ)
    {
        this.Password = Password;
        this.NickName = nick;
        this.Email = Email;
        this.profile=pf;
        this.comment_id=com;
        this.answer_id = answ;

    }//"Password","nick name","Email",null,null,null)
    public member(String password, String nickName,String email)
    {
        this.Password = password;
        this.NickName = nickName;
        this.Email = email;
    }

//    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL,mappedBy = "member")
//    List<post> Posts = new ArrayList<>();

//    @ManyToOne
//    @JoinColumn(name="POST_ID")
//    post post;
    @OneToMany(mappedBy = "member",cascade = CascadeType.ALL)
    @JsonBackReference
    List<member_post> member_posts = new ArrayList<>();




    public void addMember_Post(member_post member_post)
    {

        this.member_posts.add(member_post);
    }
//    @OneToMany
//    @JoinColumn(name = "comment_id")
//    List<comment_entity> comments = new ArrayList<>();

//    @OneToMany
//    @JoinColumn(name = "answer_id")
//    List<answer_entity> answers = new ArrayList<>();

    @OneToOne
    @JoinColumn(name = "PROFILE_ID")
    profile profile;




}
