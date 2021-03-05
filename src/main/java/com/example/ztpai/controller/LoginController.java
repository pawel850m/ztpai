package com.example.ztpai.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "signin")
public class LoginController {

    @GetMapping
    public String login(){
        return "Welcome!";
    }
}
