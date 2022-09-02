package com.team23.PreProject.tag.controller;

import com.team23.PreProject.tag.dto.tag_find;
import com.team23.PreProject.tag.entity.tag;
import com.team23.PreProject.tag.service.tag_service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class tag_controller {
    @Autowired
    tag_service tag_service;

    @GetMapping("/DBtest/tagFind")
    public ResponseEntity tagFind(@RequestParam String name)
    {
        tag tag = tag_service.findTag(name);
        if(tag == null)
            return new ResponseEntity("not exists", HttpStatus.OK);
        tag_find result = new tag_find();
        result.setName(tag.getName());
        result.setDescription(tag.getContent());
        result.setId(tag.getId());
        return new ResponseEntity(result, HttpStatus.OK);
    }


}
