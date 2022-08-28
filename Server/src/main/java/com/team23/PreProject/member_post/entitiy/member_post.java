package com.team23.PreProject.member_post.entitiy;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.team23.PreProject.member.entity.member;
import com.team23.PreProject.post.entity.post;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class member_post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="member_post_id",nullable = false)
    Integer memberPostId;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JsonManagedReference
    @JoinColumn(name = "member_id")
    member member;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JsonManagedReference
    @JoinColumn(name = "post_id")
    post post;
}
