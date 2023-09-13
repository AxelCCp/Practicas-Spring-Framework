package com.graphql.example.service;

import com.graphql.example.entity.Course;

import java.util.List;

public interface ICourseService {

    Course findById(Long id);

    List<Course> findAll();

    void createCourse(Course course);

    void deleteById(Long id);

}
