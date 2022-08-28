package com.team23.PreProject.answer.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer answer_id;

}
