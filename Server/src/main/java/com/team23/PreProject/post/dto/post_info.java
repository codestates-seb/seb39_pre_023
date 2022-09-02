package com.team23.PreProject.post.dto;

import com.team23.PreProject.tag.entity.tag;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter

public class post_info {
    Integer postId;
    String post_name;
    String post_content;
    Integer view_count;
    boolean is_answered;
    Integer score;
    List<String> tags = new ArrayList<>();
    member_info writer;

    public void addTag(String name)
    {
        this.tags.add(name);
    }
}
