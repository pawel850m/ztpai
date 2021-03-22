package com.example.ztpai.token;

import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class Token {
    public String generate(){
        return UUID.randomUUID().toString();
    }
}
