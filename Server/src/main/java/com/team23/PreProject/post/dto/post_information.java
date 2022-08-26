package com.team23.PreProject.post.dto;

import com.team23.PreProject.tag.entity.tag_entity;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.Date;

@AllArgsConstructor
public class post_information{
    int score;
    int answersCount;
    String postName;
    boolean isQuestion;
    String partOfPost;
    int views;
    int user_id;
    int stub_user_reputation;
    Date writeDate;
    ArrayList<tag_entity> tagList;


}
