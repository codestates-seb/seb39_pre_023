package com.team23.PreProject.post.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@NoArgsConstructor
@Entity
@AllArgsConstructor

public class post_entity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int post_id;

    String post_content;
    int user_id;
    String post_name;
    Date write_date;
    Date modified_date;
    int view_count;
    int comment_id;
    int answer_id;
    boolean is_answered;
    int score;
    int post_vote_id;
    int tag_id;





}
