package com.team23.PreProject.post.dto;

import com.team23.PreProject.post.entity.post;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class postWithTag {
    com.team23.PreProject.post.entity.post post;
    List<String> tags=new ArrayList<>();

    public void addTag(String name)
    {
        this.tags.add(name);
    }


}
