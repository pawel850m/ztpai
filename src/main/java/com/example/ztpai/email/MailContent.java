package com.example.ztpai.email;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@Component
@NoArgsConstructor
public class MailContent {
    private String recipient;
    private String subject;
    private String message;
}
