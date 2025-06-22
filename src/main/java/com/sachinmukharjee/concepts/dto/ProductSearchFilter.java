package com.sachinmukharjee.concepts.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Builder
@Getter
public class ProductSearchFilter {

    private List<Long> productIds;
    private String productName;
    private String languageCode;
}
