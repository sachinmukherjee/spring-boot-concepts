package com.sachinmukharjee.concepts.service;

import com.sachinmukharjee.concepts.dto.StudentCardRequest;
import com.sachinmukharjee.concepts.dto.StudentRequest;
import com.sachinmukharjee.concepts.entity.Student;
import com.sachinmukharjee.concepts.entity.StudentIdCard;
import com.sachinmukharjee.concepts.exception.APIException;
import com.sachinmukharjee.concepts.repository.IStudentRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@AllArgsConstructor
public class StudentServiceImpl implements IStudentService {

  private final IStudentRepository studentRepository;

  @Override
  public void saveStudent(StudentRequest studentRequest) {
    log.info("Got Request to Save Student Details {}", studentRequest);
    var student = convertToEntity(studentRequest);
    try {
      studentRepository.save(student);
    } catch (Exception e) {
      log.error("Exception Occured while Saving Student ", e);
      throw new APIException("Error Occurred while Saving Student");
    }
  }

  @Override
  public Student getStudent(Long id) {
    return studentRepository
        .findById(id)
        .orElseThrow(() -> new APIException("Student doesnt exists"));
  }

  private Student convertToEntity(StudentRequest studentRequest) {
    Student student = new Student();
    student.setName(studentRequest.getName());
    student.setCourse(studentRequest.getCourse());

    StudentIdCard studentIdCard = new StudentIdCard();
    studentIdCard.setCardNumber(studentRequest.getCardDetail().getCardNumber());
    studentIdCard.setIssueDate(studentRequest.getCardDetail().getIssueDate());
    studentIdCard.setStudent(student);
    student.setStudentIdCard(studentIdCard);
    return student;
  }
}
