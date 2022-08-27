package com.team23.PreProject.post_vote.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@NoArgsConstructor
@Entity
@AllArgsConstructor
@Getter
@Setter
public class post_vote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer post_vote_id;
    Integer user_id;
    Integer post_id;
    boolean post_vote_up = false;
    boolean post_vote_down = false;
}
