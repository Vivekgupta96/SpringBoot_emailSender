package com.masai.SpringBootApp.controller;


import com.masai.SpringBootApp.Service.MailService;
import com.masai.SpringBootApp.model.MailStructure;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/mail")
public class Mailcontroller {

    private final MailService mailService;

    @PostMapping("/send/{email}")
    public ResponseEntity<String> sendMail(
            @PathVariable String email, @RequestBody MailStructure mailContent){
        mailService.sendMail(email,mailContent);
        return new ResponseEntity<>("mail send successfully", HttpStatus.OK);

    }


}
