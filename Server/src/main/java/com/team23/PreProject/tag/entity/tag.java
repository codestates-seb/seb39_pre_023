package com.team23.PreProject.tag.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer tag_id;
    String tag_name;
    String tag_description;
    String stub_questions;

}
