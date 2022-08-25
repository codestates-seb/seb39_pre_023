package com.team23.PreProject.Service;

import com.team23.PreProject.Dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class AnswerService {

    public ResponseDto create(String uid){
        return new ResponseDto("/api/answer/{questionid} [POST]",uid);
    }

    public ResponseDto checked(String uid){
        return new ResponseDto("/api/answer/check/{questionid} [POST]",uid);
    }

    public ResponseDto read(String uid){
        return new ResponseDto("/api/answer/{questionid} [GET]",uid);
    }


    public ResponseDto delete(String uid){
        return new ResponseDto("/api/answer/{questionid} [DELETE]",uid);
    }

    public ResponseDto update(String uid){
        return new ResponseDto("/api/answer/{questionid} [PUT]",uid);
    }
}
