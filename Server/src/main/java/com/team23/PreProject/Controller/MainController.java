package com.team23.PreProject.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @GetMapping(value = "/v1")
    public String MainTitle() {
        return "Main version : v1";
    }




}
