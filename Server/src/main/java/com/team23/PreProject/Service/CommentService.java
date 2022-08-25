package com.team23.PreProject.Service;

import com.team23.PreProject.Dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class CommentService {
    public ResponseDto create(String uid){
        return new ResponseDto("/api/comment/{answerid} [POST]",uid);
    }


    public ResponseDto read(String uid){
        return new ResponseDto("/api/comment/{answerid} [GET]",uid);
    }


    public ResponseDto delete(String uid){
        return new ResponseDto("/api/comment/{answerid} [DELETE]",uid);
    }

    public ResponseDto update(String uid){
        return new ResponseDto("/api/comment/{answerid} [PUT]",uid);
    }
}
