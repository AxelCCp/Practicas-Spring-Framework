package com.spring.aws.domain;

import lombok.Data;

@Data
public class Personaje {

    private Long id;
    private String name;
    private Long puntosVida;
    private String[]skills;
}
