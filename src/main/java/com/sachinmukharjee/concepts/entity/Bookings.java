package com.sachinmukharjee.concepts.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "bookings")
@Getter
@Setter
public class Bookings {

  @Id private String id;
  private String itemId;
  private String customerId;
  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;

    public Bookings() {
    }

    public Bookings(String id, String itemId, String customerId) {
        this.id = id;
        this.itemId = itemId;
        this.customerId = customerId;
        LocalDateTime now = LocalDateTime.now();
        this.createdAt = now;
        this.updatedAt = now;
    }
}
