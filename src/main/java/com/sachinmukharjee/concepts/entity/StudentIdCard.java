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
  @JoinColumn(name = "student_id", referencedColumnName = "id")
  // Here student_id is foreign key
  // id is primary key in the student table

  // Multiple Join Columns. Composite Key
  /*
    @JoinColumns({
            @JoinColumn(name = "address_street",referencedColumnName = "street"),
            @JoinColumn(name = "address_pin_code",referencedColumnName = "pin_code")
    })
  */
  // Many to Many
  /*
  @JoinTable(
      name = "order_product",
      joinColumns = @JoinColumn(name = "order_id"),
      inverseJoinColumns = @JoinColumn(name = "product_id"))
   */
  @JsonBackReference
  private Student student;
}
