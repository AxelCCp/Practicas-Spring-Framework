package com.spring.mail.sender.controller;

import com.spring.mail.sender.domain.EmailDTO;
import com.spring.mail.sender.domain.EmailFileDTO;
import com.spring.mail.sender.service.IEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/v1")
public class MailController {

    @PostMapping("/sendMessage")                                                                                        //se va a recibir una peticion en json
    public ResponseEntity<?> receiveRequestEmail(@RequestBody EmailDTO emailDTO){

        System.out.println("Mensaje recibido " + emailDTO);

        emailService.sendEmail(emailDTO.getUser(), emailDTO.getSubject(), emailDTO.getMessage());
        Map<String, String> response = new HashMap<>();
        response.put("estado", "Enviado");
        return ResponseEntity.ok(response);
    }


    @PostMapping("/sendMessageFile")
    public ResponseEntity<?>receiveRequestEmailWithFile(@ModelAttribute EmailFileDTO emailFileDTO){                     //ModelAttribute : pq los datos se van a recibir como un form data.
        try{
            String filename = emailFileDTO.getFile().getOriginalFilename();                                             //obtiene el nombre. con la extension del archivo.
            Path path = Paths.get("src/mail/resources/files/" + filename);                                              //define la ruta.
            Files.createDirectories(path.getParent());                                                                  //si la ruta no existe, creala.
            Files.copy(emailFileDTO.getFile().getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);             //guarda el archivo ...   REPLACE_EXISTING : si el archivo ya existe en el directorio, lo elimina lo pone denuevo.

            File file = path.toFile();                                                                                  //se hace una referencia nuestro archivo.
            emailService.sendEmailWithFile(emailFileDTO.getUser(), emailFileDTO.getSubject(), emailFileDTO.getMessage(), file);                 //se manda el correo con archivo adj.

            Map<String, String> response = new HashMap<>();
            response.put("estado", "Enviado");
            response.put("archivo", filename);

            return ResponseEntity.ok(response);

        }catch (Exception e){
            throw new RuntimeException("Error al enviar el email con el archivo " + e.getMessage());
        }
    }

    @Autowired
    private IEmailService emailService;
}
