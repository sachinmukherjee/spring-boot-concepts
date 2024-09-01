package com.sachinmukharjee.concepts.service;

import com.sachinmukharjee.concepts.dto.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;


public class EmployeeService  implements IEmployeeService{

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeService.class);

    public EmployeeService(int id){
    LOGGER.info("EmployeeService Constructor Called.........");
    LOGGER.info("Passed Employee Id {}",id);
  }

    @Override
    public List<Employee> getAllEmployees() {
        return List.of();
    }
}
