package com.poweremabox.homeworkweek6.service;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.mail.internet.MimeMessage;

@Aspect
@Service
public class VideoEmailService {

    private final JavaMailSender emailSender;

    @Autowired
    public VideoEmailService(JavaMailSender emailSender) {
        this.emailSender = emailSender;
    }

    @ResponseBody
    @After("@annotation(EmailAspect)")
    public String sendEmail() {
        try {
            buildEmail();
            return "Email Sent!";
        }catch(Exception ex) {
            return "Error in sending email: "+ex;
        }
    }

    private void buildEmail() throws Exception{

        MimeMessage message = emailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);

        helper.setTo("email where you wanna send");
        helper.setText("Hi hope all is going well");
        helper.setSubject("Hello");

        emailSender.send(message);
    }
}

