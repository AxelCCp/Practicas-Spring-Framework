package com.spring.mail.sender.service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.io.File;
import java.nio.charset.StandardCharsets;

@Service
public class EmailServiceImpl implements IEmailService{

    @Override
    public void sendEmail(String[]toUser, String subject, String message) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom(emailUser);                                                                                 //define la cuenta esde donde va a salir email.
        mailMessage.setTo(toUser);                                                                                      //a quien le vas a mandar el email.  se puede mandar un arreglo con varios emails a quienes mandar el email.  setTo()  puede mandar a 1 o varios.
        mailMessage.setSubject(subject);                                                                                //asunto del email.
        mailMessage.setText(message);                                                                                   //mensaje de email.
        javaMailSender.send(mailMessage);
    }

    @Override
    public void sendEmailWithFile(String[]toUser, String subject, String message, File file) {                          //para trabajar con archivos se usan objs diferentes.
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        try {
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true, StandardCharsets.UTF_8.name());   //el true es de si se va a adjuntar un archivo.
            mimeMessageHelper.setFrom(emailUser);                                                                       //desde donde se manda el email.
            mimeMessageHelper.setTo(toUser);                                                                            //a qn le mandas el email.
            mimeMessageHelper.setSubject(subject);                                                                      //asunto.
            mimeMessageHelper.setText(message);                                                                         //mensaje.
            mimeMessageHelper.addAttachment(file.getName(), file);                                                      //chantale el archivo.
            javaMailSender.send(mimeMessage);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${email.sender}")
    private String emailUser;
}
