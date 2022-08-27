package com.team23.PreProject.post.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@NoArgsConstructor
@Entity
@AllArgsConstructor
@Getter
@Setter
@Builder
public class post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer POST_ID;
    public post(Integer post_id,int user_id){
        this.POST_ID = post_id;
        this.user_id = user_id;
    }




    //FK
    Integer user_id = null;
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





}
