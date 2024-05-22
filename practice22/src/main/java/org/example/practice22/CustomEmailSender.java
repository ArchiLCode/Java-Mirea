package org.example.practice22;

import lombok.AllArgsConstructor;
import org.example.practice22.entities.Feedback;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;

@org.springframework.stereotype.Service
@AllArgsConstructor
public class CustomEmailSender {
    private final JavaMailSender javaMailSender;

    @Async
    public void sendEmail(Feedback feedback) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom("artemartem3309@gmail.com");
        mailMessage.setTo("artemartem330@yandex.ru");
        mailMessage.setSubject("Добавлено что-то");
        mailMessage.setText("Добавлено: " + feedback.toString());
        javaMailSender.send(mailMessage);
    }
}