package com.graphql.example.entity;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String lastname;
    private Integer age;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Course.class)
    private Course course;
}
