package com.sachinmukharjee.concepts.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BulkOperation {

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.TABLE, generator = "user_gen")
  @TableGenerator(
      name = "user_gen",
      table = "hibernate_sequence",
      pkColumnName = "sequence_name",
      valueColumnName = "next_val",
      pkColumnValue = "user_seq",
      allocationSize = 30)
  private Long id;

  @Column(name = "uuid")
  private String uuid;
}
