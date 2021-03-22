package com.example.ztpai.email;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@Service
@AllArgsConstructor
public class MailMessage {

    private final TemplateEngine templateEngine;

    public String createBody(String mailMessage){
        Context context = new Context();
        context.setVariable("message", mailMessage);
        return templateEngine.process("MailTemplate",context);
    }
}
