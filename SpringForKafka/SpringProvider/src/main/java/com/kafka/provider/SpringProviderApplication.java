package com.kafka.provider;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;

@SpringBootApplication
public class SpringProviderApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringProviderApplication.class, args);
	}

	@Bean
	CommandLineRunner init(KafkaTemplate<String, String> kafkaTemplate) {												//se inyecta nuestro bean de kafka. Tambien se podría inyectar con autowired.
		return args -> {
			kafkaTemplate.send("unProgramadorNace-Topic", "prueba final de spring boot con kafka ...");					//va a enviar el mensaje a nuestro topic.
		};
	}

}
