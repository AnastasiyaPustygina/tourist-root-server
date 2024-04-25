package com.polytech.touristrootserver.service;

import com.polytech.touristrootserver.domain.EmailCode;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailCodeSenderSpringMail implements EmailCodeSender{

    private final JavaMailSender mailSender;

    @Override
    public void sendCode(EmailCode emailCode) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("pustygina.nastya@gmail.com");
        message.setTo(emailCode.getEmail());
        message.setSubject("Tourist Roots email checker");
        message.setText("Your email code is \n" + emailCode.getValue());

        System.out.println("message sended1");
        mailSender.send(message);
        System.out.println("message sended2 ");
    }
}
