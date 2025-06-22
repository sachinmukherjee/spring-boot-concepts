package com.sachinmukharjee.concepts.dto;

import lombok.*;

import java.sql.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentCardRequest {

  private String cardNumber;

  @Setter(AccessLevel.NONE)
  private Date issueDate = new Date(System.currentTimeMillis());

}
