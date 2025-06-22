package com.sachinmukharjee.concepts.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "OrderItem")
@IdClass(OrderItem.class)
public class OrderItem {

    @Id
    private Integer orderId;
    @Id
    private Integer itemId;
    private Integer quantity;
    private Double discount;

}
