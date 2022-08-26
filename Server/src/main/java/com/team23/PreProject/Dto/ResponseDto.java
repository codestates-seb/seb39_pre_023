package com.team23.PreProject.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class ResponseDto {
    public String request;
    public String parameter;
    public String postId;
    public String postName;
    public String postContent;
    public String createAt;
    public String modifiedAt;
    public String writerId;

    public ResponseDto(String request,String parameter)
    {
        this.request = request;
        this.parameter=parameter;
    }

}
