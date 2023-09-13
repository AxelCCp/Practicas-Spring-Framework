package com.graphql.example.service;

import com.graphql.example.entity.Course;
import com.graphql.example.persitence.ICourseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CourseServiceImpl implements ICourseService{

    @Override
    @Transactional(readOnly = true)
    public Course findById(Long id) {
        return courseDao.findById(id).orElseThrow();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Course> findAll() {
        return (List<Course>) courseDao.findAll();
    }

    @Override
    @Transactional
    public void createStudent(Course course) {
        courseDao.save(course);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        courseDao.deleteById(id);
    }

    @Autowired
    private ICourseDao courseDao;
}
