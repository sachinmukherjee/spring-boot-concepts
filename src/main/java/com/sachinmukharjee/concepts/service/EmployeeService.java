package com.sachinmukharjee.concepts.service;

import com.sachinmukharjee.concepts.repository.EmployeeRepository;
import com.sachinmukharjee.concepts.entity.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public class EmployeeService  implements IEmployeeService{

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeService.class);

    @Autowired
    private EmployeeRepository employeeRepository;

    public EmployeeService(int id){
    LOGGER.info("EmployeeService Constructor Called.........");
    LOGGER.info("Passed Employee Id {}",id);
  }

    @Override
    public List<Employee> getAllEmployees() {
      Page<Employee> employees =  employeeRepository.findAll(Pageable.ofSize(50));
      return employees.get().toList();
    }
}
