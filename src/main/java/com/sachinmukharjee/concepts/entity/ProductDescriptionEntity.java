package com.sachinmukharjee.concepts.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "product_description")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDescriptionEntity {

    @Id
    @Column(name = "description_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer descriptionId;

    @Column(name = "product_id")
    private Integer product;

    @Column(name = "language_code")
    private String languageCode;

    @Column(name = "description")
    private String description;
}
