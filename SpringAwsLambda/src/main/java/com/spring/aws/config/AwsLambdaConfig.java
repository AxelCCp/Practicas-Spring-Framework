package com.spring.aws.config;

import com.spring.aws.domain.Personaje;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

@Configuration
public class AwsLambdaConfig {

    // Supplier : SE USA EL GET EN EL POSTMAN
    @Bean
    public Supplier<String>greeting(){
        return () -> {
            return "Hello mundo";
        };
    }

    // Supplier : SE USA EL GET EN EL POSTMAN
    @Bean(name="saludar")
    public Supplier<String>greeting2(){
        return () -> {
            return "Hello mundo";
        };
    }


    //Consumer :  esto lo llamas así desde el postman:
    //GET : "localhost:8080/print-param/Hola!!!!!!!!!!!!!!!!!!!"
    //POST : "localhost:8080/print-param"  + manda el parametro en el raw con text

    @Bean(name="print-param")
    public Consumer<String>printParam(){
        return (param) -> {
            System.out.println(param);
        };
    }

    //Function : se puede llamar con get o post. sirve para retornar un valor
    @Bean(name="recibe-param")
    public Function<String, String> recibirParam(){                                                                     //<String, String> : recibe un parametro string y devuelve un string.
        return (param) -> {
            String name = param.toUpperCase();
            return name;
        };
    }


    //genera un json con supplier
    @Bean(name="crea-personaje")
    public Supplier<Map<String, Object>>createPersonaje(){
        return () -> {
            Map <String, Object> personaje = new HashMap<>();
            personaje.put("nombre", "Goku");
            personaje.put("puntosVida", 100);
            personaje.put("skill", "Kame hame ha");
            return personaje;
        };
    }

    //recibe un json y devuelve un string
    @Bean(name="recibe-json")
    public Function<Map<String, Object>, String>recibeJson(){
        return (param) -> {
            param.forEach((key, value) -> System.out.println(key + " -  " + value.toString()));
            return "Personaje recibido";
        };
    }


    //recibe un obj y devuelve un json
    @Bean(name="recibe-devuelve-json")
    public Function<Personaje, Personaje>recibeObj(){
        return (param)-> {
            return param;
        };
    }


    //recibe un json y devuelve un json

    @Bean(name="recibe-json-devuelve-json")
    public Function <Map<String, Object>, Map<String, Object>> procesarPersonajes(){
        return (param) -> {
            Map<String, Object> mapPersonaje = param;
            mapPersonaje.forEach( (key, value) -> System.out.println(key + " -  " + value.toString()));

            Map<String, Object> nuevoPersonaje = new HashMap<>();
            nuevoPersonaje.put("name", "Kshrlin");
            nuevoPersonaje.put("puntosVida", 50);
            nuevoPersonaje.put("skills", new String[]{"Ki n San", "kame hame ha"});
            return nuevoPersonaje;
        };
    }

    @Bean
    public Filter getFilter(){
        return new SecurityFilter();
    }

}
