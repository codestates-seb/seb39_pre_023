package com.team23.PreProject.post_vote.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class post_vote_entity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int post_vote_id;
    int user_id;
    int post_id;
    boolean post_vote_up;
    boolean post_vote_down;
}
