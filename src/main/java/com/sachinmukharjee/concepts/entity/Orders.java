package com.sachinmukharjee.concepts.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Entity
@Table(name = "Orders")
@NoArgsConstructor
@Getter
@Setter
public class Orders {

  @Id
  @Column(name = "order_id")
  private Integer orderId;

  @Column(name = "customer_name")
  private String customerName;

  @Column(name = "order_date")
  private Date orderDate;
}
