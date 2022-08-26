package com.team23.PreProject.Controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@RestController

public class MainController {

    @CrossOrigin
    @GetMapping(value = "/")
    public ResponseEntity comment_read() {
        System.out.println("main page request " + LocalDate.now() +" "+ LocalTime.now().format(DateTimeFormatter.ofPattern("HH시 mm분 ss초")));
        return new ResponseEntity("main page ",HttpStatus.OK);
    }

}
