package com.team23.PreProject.post.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.team23.PreProject.member.entity.member;

import com.team23.PreProject.member_post.entitiy.member_post;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Entity
@AllArgsConstructor
@Getter
@Setter
@Table(name="POST")
//json requestbody로 매핑시 json의 키 네임은 소문자로 시작
//간단히 요약하면 클래스의 이름은 일반적으로 대문자로 시작하지만, 개발자들은 식별자가 소문자로 시작하는 것에 익숙하기 때문에 첫 번째 글자를 소문자로 변환한다는 겁니다.
//다만, 모든 문자를 대문자로 사용하는 경우도 있기 때문에 이런 경우는 예외로 둔다고 합니다.
//그리고 예외 케이스를 판별하기 위해 첫 두 문자가 모두 대문자인지를 확인합니다.

public class post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "POST_ID")
    Integer postId = null;

    @Column(name = "POST_NAME")
    String post_name;
    @Column(name = "POST_CONTENT")
    String post_content;
    @Column(name = "VIEW_COUNT")
    Integer view_count = 1;
    @Column(name = "IS_ANSWERED")
    boolean is_answered = false;
    @Column(name = "SCORE")
    Integer score = 0;
//    @Column(name = "MEMBER_POST_ID")
//    Integer member_post_id;

    @Column(name = "WRITE_DATE")
    LocalDateTime write_date = LocalDateTime.now();
    @Column(name = "MODIFIED_DATE")
    LocalDateTime modified_date = LocalDateTime.now();;

//    @ManyToOne(fetch = FetchType.EAGER,optional = false)
//    @JoinColumn(name = "MEMBER_ID")
//    @JsonBackReference
//    member member;

    @OneToMany(mappedBy = "post",cascade = CascadeType.ALL)
    @JsonBackReference
    List<member_post> member_posts = new ArrayList<>();


    public void addMember_Post(member_post member_post) {
        this.member_posts.add(member_post);

    }




}
