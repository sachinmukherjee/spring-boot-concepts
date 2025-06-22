package com.sachinmukharjee.concepts.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Entity
@Table(name = "student_id_card")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentIdCard {

  @Id
  @Column(name = "id", insertable = true, updatable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "card_number")
  private String cardNumber;

  @Column(name = "issue_date")
  private Date issueDate;

  @OneToOne
  @JoinColumn(name = "student_id",referencedColumnName = "id")
  @JsonBackReference
  private Student student;
}
