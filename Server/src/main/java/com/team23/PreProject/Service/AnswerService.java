package com.team23.PreProject.Service;

import com.team23.PreProject.Dto.ResponseDto;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

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

    public ResponseDto read_test(String uid){
        return new ResponseDto("/api/answer/{questionid} [GET]",uid,"555555","i have question about spring","Spring is so HOT!", LocalDate.now() +" "+ LocalTime.now().format(DateTimeFormatter.ofPattern("HH시 mm분 ss초")),LocalDate.now() +" "+ LocalTime.now().format(DateTimeFormatter.ofPattern("HH시 mm분 ss초")),"wonyong" );
    }

    public ResponseDto delete(String uid){
        return new ResponseDto("/api/answer/{questionid} [DELETE]",uid);
    }

    public ResponseDto update(String uid){
        return new ResponseDto("/api/answer/{questionid} [PUT]",uid);
    }
}
