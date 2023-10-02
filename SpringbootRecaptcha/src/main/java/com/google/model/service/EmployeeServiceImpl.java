package com.google.model.service;

import com.google.model.dao.EmployeeDao;
import com.google.model.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EmployeeServiceImpl implements  EmployeeService{

    @Override
    public List<Employee> findAll() {
        return employeeDao.findAll();
    }

    @Override
    public Employee findById(Long id) {
        return employeeDao.findById(id).orElse(null);
    }

    @Override
    public void createEmployee(Employee employee) {
        employeeDao.save(employee);
    }

    @Override
    public void deleteById(Long id) {
        employeeDao.deleteById(id);
    }


    @Autowired
    private EmployeeDao  employeeDao;
}
