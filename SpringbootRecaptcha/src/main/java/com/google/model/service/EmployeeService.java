package com.google.model.service;

import com.google.model.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();
    Employee findById(Long id);
    void createEmployee(Employee employee);
    void deleteById(Long id);


}
