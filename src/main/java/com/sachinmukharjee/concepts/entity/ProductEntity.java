package com.sachinmukharjee.concepts.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.boot.actuate.audit.listener.AuditListener;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "product")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "product_id")
  private Integer productId;

  @Column(name = "product_name")
  private String productName;

  @Column(name = "category")
  private String category;

  @Column(name = "price")
  private Double price;

  @Column(name = "stock_quantity")
  private Integer stockQuantity;

  @OneToMany(mappedBy = "product", orphanRemoval = true, fetch = FetchType.LAZY)
  @OrderBy("descriptionId ASC")
  private Set<ProductDescriptionEntity> descriptions = new LinkedHashSet<>();
}
