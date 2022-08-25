package com.team23.PreProject.Service;

import com.team23.PreProject.Dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class ProfileService {

    public ResponseDto delete(String uid){
        return new ResponseDto("/api/users/picture/{uid} [DELETE]",uid);
    }

    public ResponseDto update(String uid){
        return new ResponseDto("/api/users/picture/{uid} [POST]",uid);
    }


}
