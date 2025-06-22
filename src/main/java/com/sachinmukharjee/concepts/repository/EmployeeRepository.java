package com.sachinmukharjee.concepts.repository;

import com.sachinmukharjee.concepts.entity.Employee;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends PagingAndSortingRepository<Employee,Integer> {

}
