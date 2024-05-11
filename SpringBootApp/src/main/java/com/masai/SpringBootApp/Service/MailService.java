package com.masai.SpringBootApp.Service;

import com.masai.SpringBootApp.model.MailStructure;

public interface MailService {

    void sendMail(String mailId, MailStructure mail);
}
