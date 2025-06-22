package com.sachinmukharjee.concepts.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Version;

@Entity
@Table(name = "account")
@Getter
@Setter
@NoArgsConstructor
public class Accounts {

  @Id
  @Column(name = "id")
  private int id;

  @Column(name = "name")
  private String name;

  @Column(name = "balance")
  private Double balance;

  @Version
  private Long version;
}
