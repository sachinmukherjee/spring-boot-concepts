package com.sachinmukharjee.concepts.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Items")
@Getter
@Setter
public class Items {

  @Id
  @Column(name = "item_id")
  private Integer itemId;

  @Column(name = "item_name")
  private String itemName;

  @Column(name = "price")
  private Double price;
}
