package com.masai.SpringBootApp.Service.Impl;

import com.masai.SpringBootApp.Service.MailService;
import com.masai.SpringBootApp.exception.MailSenderException;
import com.masai.SpringBootApp.model.MailStructure;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Date;

@Slf4j
@Service
public class MailServiceImpl implements MailService {

    @Value("${spring.mail.username}")
    private String mailSendFrom;

    @Autowired
    private JavaMailSender mailSender;

    @Override
    public void sendMail(String mailId, MailStructure mail) {

        try{
            SimpleMailMessage email=new SimpleMailMessage();
            email.setFrom(mailSendFrom);
            email.setSubject(mail.getMailSubject());
            email.setText(mail.getMailBody());
            email.setTo(mailId);
            email.setSentDate(new Date());
            mailSender.send(email);
        }catch (Exception e){
            log.error(e.getMessage());
            throw new MailSenderException(
                    "Failed to sending the email to user with Id :"+mailId);

        }

    }
}
