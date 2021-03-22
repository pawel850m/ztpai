package com.example.ztpai.email;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class MailContent {
    private String recipient;
    private String subject;
    private String message;
}
