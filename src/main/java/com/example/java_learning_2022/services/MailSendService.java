package com.example.java_learning_2022.services;

import com.example.java_learning_2022.models.entitty.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

@Service
public class MailSendService {

    @Autowired
    private JavaMailSender javaMailSender;

    public void send(User user, MultipartFile multipartFile) {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);
        try {
            mimeMessage.setFrom(new InternetAddress("yermakov.oleksandr.o@gmail.com"));
            helper.setTo(user.getEmail());
            helper.setText("<h1>message</h1>", true);
            helper.addAttachment("some file", multipartFile);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        javaMailSender.send(mimeMessage);
    }
}
