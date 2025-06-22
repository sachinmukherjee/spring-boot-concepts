package com.sachinmukharjee.concepts.service;

import com.sachinmukharjee.concepts.dto.StudentCardRequest;
import com.sachinmukharjee.concepts.dto.StudentRequest;
import com.sachinmukharjee.concepts.entity.Student;

public interface IStudentService {

    void saveStudent(StudentRequest studentRequest);

    Student getStudent(Long id);
}
