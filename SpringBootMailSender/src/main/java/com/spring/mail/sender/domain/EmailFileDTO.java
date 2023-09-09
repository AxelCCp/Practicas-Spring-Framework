package com.spring.mail.sender.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class EmailFileDTO {
    private String[]User;
    private String subject;
    private String message;

    MultipartFile file;
}
