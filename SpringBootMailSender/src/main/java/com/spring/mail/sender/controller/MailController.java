package com.spring.mail.sender.controller;

import com.spring.mail.sender.domain.EmailDTO;
import com.spring.mail.sender.service.IEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
public class MailController {

    @PostMapping("/sendMessage")                                                                                        //se va a recibir una peticion en json
    public ResponseEntity<?> receiveRequestEmail(@RequestBody EmailDTO emailDTO){

        System.out.println("Mensaje recibido " + emailDTO);

        emailService.sendEmail(56:01 min);

        return (ResponseEntity<?>) ResponseEntity.ok();
    }

    @Autowired
    private IEmailService emailService;
}
