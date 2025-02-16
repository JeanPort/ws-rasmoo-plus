package com.cliente.ws.rasmooplus.integration;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class MailIntegrationImpl implements MailIntegration{

    private final JavaMailSender mailSender;

    public MailIntegrationImpl(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    @Override
    public void sendMail(String mailTo, String message) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(mailTo);
        mailMessage.setSubject(message);
        mailMessage.setText("Login: " + mailTo + ", senha: 1234");

        mailSender.send(mailMessage);
    }
}
