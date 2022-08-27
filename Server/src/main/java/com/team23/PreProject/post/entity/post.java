package com.team23.PreProject.post.entity;

import com.team23.PreProject.user.entity.member;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor
@Entity
@AllArgsConstructor
@Getter
@Setter

public class post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer postId;
       //FK
    
    Integer comment_id = null ;
    Integer answer_id= null ;
    Integer post_vote_id= null ;
    Integer tag_id= null ;

    String post_name;
    String post_content;

    Integer view_count = 1;
    boolean is_answered = false;
    Integer score = 0;


    LocalDateTime write_date;
    LocalDateTime modified_date;
    @ManyToOne
    @JoinColumn(name = "user_id")
    member member;



}
