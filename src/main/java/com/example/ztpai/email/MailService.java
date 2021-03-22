package com.example.ztpai.email;

import lombok.AllArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MailService {

    private final MailMessage mailMessage;
    private final JavaMailSender javaMailSender;

    @Async
    public void sendMail(MailContent mailContent){
        MimeMessagePreparator messagePreparator = mimeMessage -> {
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage);
            mimeMessageHelper.setFrom("email@email.com");
            mimeMessageHelper.setTo(mailContent.getRecipient());
            mimeMessageHelper.setSubject(mailContent.getSubject());
            mimeMessageHelper.setText(mailMessage.createBody(mailContent.getMessage()));
        };
        javaMailSender.send(messagePreparator);
    }
}
