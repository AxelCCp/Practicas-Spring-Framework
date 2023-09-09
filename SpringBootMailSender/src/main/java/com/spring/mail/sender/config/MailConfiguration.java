package com.spring.mail.sender.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

//configuracion del obj que se encarga de enviar los correos electronicos.

@Configuration
public class MailConfiguration {

    @Bean
    public JavaMailSender getJavaMailSender(){
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.gmail.com");                                                                           //establece el protocolo
        mailSender.setPort(587);                                                                                        //587 es el puerto por defecto para el protocolo smtp.
        mailSender.setUsername(emailUser);                                                             //correo electronico con el cual se va a mandar el email.
        mailSender.setPassword("<Password>");                                                                           //esta no se pone directamente por seguridad.

        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");                                                                   //se inldica q se va a usar el protocolo smtp para mandar el email. indicamos el host del correo.
        props.put("mail.smtp.auth", "true");                                                                            //cuando la app use el protocolo smtp, la app se va a autenticar con el usuario y la contraseña,   y recien ahí puede mandar el email.
        props.put("mail.smtp.starttls", "true");                                                                        // * IMPORTANTE: habilita el cifrado entre la comunicacion de la app y el cooreo electronico, mediante smtp.
        props.put("mail.debug", "true");                                                                                // * esta se ocupa en desarrollo, se usa para q en la consola vaya impriemiendo informacion acerca de la comunicacin entre el correo y la app-

        return mailSender;
    }


    @Value("${email.sender}")
    private String emailUser;

}
