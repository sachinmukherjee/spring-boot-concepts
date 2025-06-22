package com.sachinmukharjee.concepts.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ProductResponse {
    private Integer id;
    private String productName;
    private String category;
    private Double price;
    private Integer stockQuantity;
    private Set<ProductDescriptionResponse> description;
}
