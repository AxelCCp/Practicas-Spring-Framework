package com.spring.mail.sender.domain;

//CON JAVA 17 - los record aparecieron oficialmente en java 17 y sirven para declarar los atributos de los q sería una clase, directamente en parametros.
/*
public record EmailDTO(String[]User,
                       String subject,
                       String message) {}
*/

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

//CON VERSION ANTERIOR A JAVA 17
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class EmailDTO{
    private String[]user;
    private String subject;
    private String message;
}

