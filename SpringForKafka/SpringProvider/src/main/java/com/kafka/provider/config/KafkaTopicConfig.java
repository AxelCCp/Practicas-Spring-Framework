package com.kafka.provider.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.common.config.TopicConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaTopicConfig {

    //52 min
    @Bean
    public NewTopic generateTopic(){

        Map<String,String> configurations = new HashMap<>();
        configurations.put(TopicConfig.CLEANUP_POLICY_CONFIG, TopicConfig.CLEANUP_POLICY_DELETE);                       //configuracion del tratamiento de borrado de los mensajes. // propiedades que se pueden elegir : delete(borra mensajes) compact(mantiene los mensajes)
        configurations.put(TopicConfig.RETENTION_MS_CONFIG, "86400000");                                                //configuracion del tiempo q va retener los mensajes,  en milisegundos. por defecto esto viene en -1 ,  lo q quiere decir q no se van a borrar nunca.
        configurations.put(TopicConfig.SEGMENT_BYTES_CONFIG, "1073741824");                                             //tamaño maximo de los segmentos dentro del topic. 1073741824 esto es 1GB
        configurations.put(TopicConfig.MAX_MESSAGE_BYTES_CONFIG,"1000012");                                             //tamaño maximo de cada mensaje. esta propiedad por defecto viene en 1 megabyte.

        NewTopic newTopic = TopicBuilder.name("unProgramadorNace-Topic")
                .partitions(2)
                .replicas(2)
                .configs(configurations)
                .build();

        return  newTopic;
    }

}
