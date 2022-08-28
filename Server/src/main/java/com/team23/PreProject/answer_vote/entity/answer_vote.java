package com.team23.PreProject.answer_vote.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class answer_vote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer answer_vote_id;
}
