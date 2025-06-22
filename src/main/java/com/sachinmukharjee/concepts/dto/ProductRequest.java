package com.sachinmukharjee.concepts.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequest {
    private String productName;
    private String category;
    private Double price;
    private Integer stockQuantity;
    private Set<ProductDescriptionRequest> description;
}
