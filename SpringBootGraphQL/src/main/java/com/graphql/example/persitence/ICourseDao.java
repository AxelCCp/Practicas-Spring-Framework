package com.graphql.example.persitence;

import com.graphql.example.entity.Course;
import org.springframework.data.repository.CrudRepository;

public interface ICourseDao extends CrudRepository<Course, Long> {}
