package com.sachinmukharjee.concepts.repository;

import com.sachinmukharjee.concepts.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IStudentRepository extends JpaRepository<Student,Long> {


    @Query("select e from Student e where e.name = 'Sachin' and e.course = 'Java'")
    List<Student> findBad();


    @Query("select e from Student e where e.name = :name and e.course = :course")
    List<Student> findGood(@Param("name") String name, @Param("course") String course);
}
