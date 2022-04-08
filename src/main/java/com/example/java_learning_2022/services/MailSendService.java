package com.example.java_learning_2022.services;

import lombok.AllArgsConstructor;
import com.example.java_learning_2022.models.entitty.User;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

@Service
@AllArgsConstructor
public class MailSendService {
    private JavaMailSender javaMailSender;

    public void send(User user, MultipartFile multipartFile) throws MessagingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        try {
            mimeMessage.setFrom(new InternetAddress("my_email@gmail.com"));
            helper.setTo(user.getEmail());
            helper.setText("<h1>My message</h1>", true);

            String fileFormat = multipartFile.getContentType().split("/")[1];
            helper.addAttachment("myPhoto." + fileFormat, multipartFile);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        javaMailSender.send(mimeMessage);
    }
}
