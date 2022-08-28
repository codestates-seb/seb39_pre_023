package com.team23.PreProject.post.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class post_insert_dto {
    String post_name;
    String post_content;
    Integer member_id;
}
