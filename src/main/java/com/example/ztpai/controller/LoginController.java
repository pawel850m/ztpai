package com.example.ztpai.controller;

import com.example.ztpai.model.User;
import com.example.ztpai.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/auth/signin")
public class LoginController {

    private final LoginService loginService;

    @Autowired
    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @GetMapping
    public String login(@RequestBody User user){
        return loginService.login(user);
    }
}
