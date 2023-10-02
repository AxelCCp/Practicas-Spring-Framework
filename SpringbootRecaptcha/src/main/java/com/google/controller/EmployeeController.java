package com.google.controller;


import com.google.controller.dto.EmployeeDto;
import com.google.model.entity.Employee;
import com.google.model.service.EmployeeService;
import com.google.model.service.ReCaptchaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class EmployeeController {

    @GetMapping(path = {"/", "/all"})
    public String showAll(Model model){
        List<Employee>employeeList = employeeService.findAll();
        model.addAttribute("employees", employeeList);
        return "index";
    }

    @GetMapping("/create/form")
    public String createForm(Model model){
        model.addAttribute("employee", new Employee());
        return "form";
    }

    @PostMapping("/create/process")
    public String createProcess(@ModelAttribute(name="employee") EmployeeDto employeeDto, @RequestParam(name="g-recaptcha-response") String captcha, Model model){

        boolean captchaValid = reCaptchaService.validateRecaptcha(captcha);

       if(captchaValid){
           Employee employee = Employee.builder()
                   .name(employeeDto.getName())
                   .lastname(employeeDto.getLastname())
                   .dateOfBirth(employeeDto.getDateOfBirth())
                   .build();
           employeeService.createEmployee(employee);
           return "redirect:/all";
       } else {
            model.addAttribute("message", "captcha invalido");
            return "error";
       }



    }





    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private ReCaptchaService reCaptchaService;

}
