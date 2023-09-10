package com.spring.mail.sender.domain;


import lombok.*;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter                 //form-data necesita usar el setter para enviar el archivo.
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class EmailFileDTO {
    private String[]User;
    private String subject;
    private String message;
    private MultipartFile file;
}
