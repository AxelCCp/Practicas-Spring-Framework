package com.graphql.example.controller;

import com.graphql.example.entity.Course;
import com.graphql.example.graphQL.InputCourse;
import com.graphql.example.service.ICourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
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

    @MutationMapping(name = "createCourse")
    public Course createCourse(@Argument(name = "inputCourse") InputCourse inputCourse){
        Course course = new Course();
        course.setName(inputCourse.getName());
        course.setCategory(inputCourse.getCategory());
        course.setTeacher(inputCourse.getTeacher());
        courseService.createCourse(course);
        return course;
    }

    @MutationMapping(name = "deleteCourseById")
    public String deleteById(@Argument(name = "courseId") String courseId){
        courseService.deleteById(Long.valueOf(courseId));
        return "El curso con id " + courseId + " ha sido eliminado";
    }

    @Autowired
    private ICourseService courseService;
}
