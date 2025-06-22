package com.sachinmukharjee.concepts.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "employee")
public class Employee {

  @Id
  @Column(name = "emp_no")
  private int empNo;

  @Column(name = "first_name")
  private String firstName;

  @Column(name = "last_name")
  private String lastName;

  @Column(name = "gender")
  private String gender;

  public Employee() {}

  public Employee(int empNo, String firstName, String lastName, String gender) {
    this.empNo = empNo;
    this.firstName = firstName;
    this.lastName = lastName;
    this.gender = gender;
  }

  public int getEmpNo() {
    return empNo;
  }

  public void setEmpNo(int empNo) {
    this.empNo = empNo;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  @Override
  public String toString() {
    return "Employee{"
        + "empNo="
        + empNo
        + ", firstName='"
        + firstName
        + '\''
        + ", lastName='"
        + lastName
        + '\''
        + ", gender='"
        + gender
        + '\''
        + '}';
  }
}
