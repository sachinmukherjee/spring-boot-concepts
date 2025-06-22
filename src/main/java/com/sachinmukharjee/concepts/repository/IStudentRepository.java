package com.sachinmukharjee.concepts.repository;

import com.sachinmukharjee.concepts.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IStudentRepository extends JpaRepository<Student,Long> {}
