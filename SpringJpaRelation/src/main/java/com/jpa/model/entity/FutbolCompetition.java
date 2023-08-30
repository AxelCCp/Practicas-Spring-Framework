package com.jpa.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="FutbolCompetition")
public class FutbolCompetition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="name", columnDefinition = "VARCHAR(300)")//, nullable = false)                                           //  nullable = false -> not null en la bbdd.
    private String name;
    @Column(name="quantity_price")//, length = 10, nullable = false, unique = true)                                     //length:maximo de caracteres. nullable:no puede ser nulo. unique:no se puede repetir.
    private String quantityPrice;
    @Column(name="start_date", columnDefinition = "DATE")                                                               //especifica el tipo de dato, ya q localdate a veces da problemas con jpa.
    private LocalDate startDate;
    @Column(name="end_date", columnDefinition = "DATE")
    private LocalDate endDate;


}
