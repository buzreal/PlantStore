package com.example.course3.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/test")
public class RestController {
    @GetMapping
    public String test(){
        return "Data Structures and Persistence are pretty good.";
    }
}
