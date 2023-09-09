package com.kafka.provider.config;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import java.util.HashMap;
import java.util.Map;

//min 1.02
@Configuration
public class KafkaProviderConfig {


    @Value("${spring.kafka.bootstrapServers}")
    private String bootstrapServers;

    public Map<String, Object> producerConfig(){                                                                        //congiguracion del proveedor de mensajes de kafka

        Map<String, Object> properties = new HashMap<>();
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);                                      //le decimos donde esta el servidor de kafka
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);                             //cual va a ser el obj que se va a encargar de serializar el mensaje. StringSerializer : convierte nuestro string en bytes para q se pueda mandar por medio de kafka.
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        return properties;
    }

                                                                                                                        //con esto generamos la fabrica que nos va a proveer de ese cliente que necesitamos para enviar los mensajes.
    @Bean
    public ProducerFactory<String, String> providerFactory() {
        return new DefaultKafkaProducerFactory<>(producerConfig());
    }


    @Bean
    public KafkaTemplate<String, String> kafkaTemplate(ProducerFactory<String, String> providerFactory){                //el providerFactory se pasa como inyeccion de dependencia pq es un bean. se podría pasar directamente en los () de new KafkaTemplate<>(), pero lo correcto es pasarlo por argumento.
        return new KafkaTemplate<>(providerFactory);
    }

}
