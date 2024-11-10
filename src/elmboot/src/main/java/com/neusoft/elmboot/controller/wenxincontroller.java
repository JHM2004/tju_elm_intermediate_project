package com.neusoft.elmboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.neusoft.elmboot.service.WenXinService;

@RestController
@RequestMapping("/wenxincontroller")
@CrossOrigin
public class wenxincontroller {
    @Autowired
    private WenXinService wenXinService;
    
    @PostMapping("/query")
    public String query(@RequestBody String question){
        String answers = wenXinService.wenXinTest(question);
        return answers;
    }
}

