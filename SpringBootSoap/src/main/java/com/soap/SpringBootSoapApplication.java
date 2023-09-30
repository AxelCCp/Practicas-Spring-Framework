package com.soap;

import com.soap.client.SoapClient;
import com.soap.wsdl.AddResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootSoapApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootSoapApplication.class, args);
	}

	/*@Bean
	CommandLineRunner init(SoapClient soapClient){
		return args -> {
			AddResponse addResponse = soapClient.getAddResponse(2,2);
			LOGGER.info("-------------------------------------------------");
			LOGGER.info("resultado de suma de los numeros {} y {} es: {}", 2, 2, addResponse.getAddResult());
		};
	}*/



	//private final static Logger LOGGER = LoggerFactory.getLogger(SpringBootSoapApplication.class);

}
