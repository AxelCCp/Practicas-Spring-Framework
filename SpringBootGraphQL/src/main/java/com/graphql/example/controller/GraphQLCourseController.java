package com.graphql.example.controller;

import com.graphql.example.entity.Course;
import com.graphql.example.service.ICourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class GraphQLCourseController {

    @QueryMapping(name = "findCourseById")
    public Course findById(@Argument(name = "courseId") String id){
        Long courseId = Long.parseLong(id);
        return courseService.findById(courseId);
    }

    @QueryMapping(name = "findAllCourses")
    public List<Course>findAllCourses(){
       return courseService.findAll();
    }

    @Autowired
    private ICourseService courseService;
}
