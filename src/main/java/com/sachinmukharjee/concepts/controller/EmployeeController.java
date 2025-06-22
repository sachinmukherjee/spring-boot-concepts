package com.sachinmukharjee.concepts.controller;

import com.sachinmukharjee.concepts.entity.Employee;
import com.sachinmukharjee.concepts.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {


    @Autowired
    private IEmployeeService employeeService;

    /*
    Constructor Injection
    @Autowired
    public EmployeeController(IEmployeeService employeeService){
        this.employeeService=employeeService;
    }
    */
    @GetMapping("/all")
    public List<Employee> getAllEmployee(){
        return employeeService.getAllEmployees();
    }


    /*
    Setter Injection
    @Autowired
    public void setEmployeeService(IEmployeeService employeeService) {
        this.employeeService = employeeService;
    }
     */
}
