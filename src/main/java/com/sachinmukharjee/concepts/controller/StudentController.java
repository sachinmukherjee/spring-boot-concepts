package com.sachinmukharjee.concepts.controller;

import com.sachinmukharjee.concepts.dto.StudentRequest;
import com.sachinmukharjee.concepts.entity.Student;
import com.sachinmukharjee.concepts.service.IStudentService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/student")
@AllArgsConstructor
public class StudentController {

    private final IStudentService studentService;

    @PostMapping
    public ResponseEntity<Void> saveStudent(@RequestBody(required = true) StudentRequest studentRequest){
        studentService.saveStudent(studentRequest);
        return ResponseEntity.ok(null);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable Long id){
        return ResponseEntity.ok(studentService.getStudent(id));
    }
}
