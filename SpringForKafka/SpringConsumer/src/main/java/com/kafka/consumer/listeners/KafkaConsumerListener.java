package com.kafka.consumer.listeners;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;

@Configuration
public class KafkaConsumerListener {

    private Logger LOGGER = LoggerFactory.getLogger(KafkaConsumerListener.class);


    @KafkaListener(topics = {"unProgramadorNace-Topic"}, groupId = "my-group-id")                                       //para q funcione como listener,  se le pone esta anotacion. y se ponen los topics que vamos a estar escuchando.   // es un identificador de grupos de consumidores. por ejemplo puede haber varios consumidores q necesitan este mensaje, entonces se pone el grupo de consumidores con quienes se va a compartir.   // se le ponen en este caso cualquier groupid. siempre debe ponerse esto para que funcione.
    public void listener(String message){
        LOGGER.info("Mensaje recibido,  el mensaje es : " + message);
    }

}

