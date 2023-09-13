package com.graphql.example.controller;

import com.graphql.example.entity.Course;
import com.graphql.example.entity.Student;
import com.graphql.example.graphQL.ImputStudent;
import com.graphql.example.service.ICourseService;
import com.graphql.example.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class GraphQLStudentController {

    @QueryMapping(name="findStudentById")
    public Student findById(@Argument(name="studentId") String id){
        Long studentId = Long.parseLong(id);
        return studentService.findById(studentId);
    }

    @QueryMapping(name="findAllStudents")
    public List<Student> findAll(){
        return studentService.findAll();
    }

    @MutationMapping(name="createStudent")
    public Student createStudent(@Argument(name="inputStudent") ImputStudent inputStudent){
        Student student = new Student();
        student.setName(inputStudent.getName());
        student.setLastname(inputStudent.getLastname());
        student.setAge(inputStudent.getAge());
        Course course = courseService.findById(Long.valueOf(inputStudent.getCourseId()));
        student.setCourse(course);
        studentService.createStudent(student);
        return student;
    }


    @MutationMapping(name = "deleteStudentById")
    public String deleteById(@Argument(name = "studentId") String id){
        studentService.deleteById(Long.valueOf(id));
        return "El estudiante con id " + id + "ha sido eliminado";
    }

    @Autowired
    private IStudentService studentService;

    @Autowired
    private ICourseService courseService;
}
